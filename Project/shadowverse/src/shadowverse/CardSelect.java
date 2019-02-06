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

import beans.DeckDetailDataBeans;
import dao.DeckDetailDAO;

/**
 * Servlet implementation class CardSelect
 */
@WebServlet("/CardSelect")
public class CardSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CardSelect() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String deckname = request.getParameter("name");
			String classId = request.getParameter("classId");

			DeckDetailDAO deckdetaildao=new DeckDetailDAO();
			List<DeckDetailDataBeans> cardselectList=deckdetaildao.ClassSelectList(classId);


			request.setAttribute("deckname", deckname);
			request.setAttribute("classId", classId);
			request.setAttribute("cardselectList",cardselectList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardselect.jsp");
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
		doGet(request, response);
	}

}
