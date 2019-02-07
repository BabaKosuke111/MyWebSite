package shadowverse;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CardDetailDataBeans;
import dao.CardDetailDAO;

/**
 * Servlet implementation class AllCard
 */
@WebServlet("/AllCard")
public class AllCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			CardDetailDAO carddetaildao=new CardDetailDAO();
			List<CardDetailDataBeans> AllCardList=carddetaildao.findAllCardInfo();

			request.setAttribute("AllCardList", AllCardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allcard.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String cardName=request.getParameter("cardName");
			String className=request.getParameter("className");

			CardDetailDAO carddetaildao = new CardDetailDAO();
			List<CardDetailDataBeans>  AllCardList = carddetaildao.findAllCardSearch(cardName, className);

			request.setAttribute("AllCardList",AllCardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allcard.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
