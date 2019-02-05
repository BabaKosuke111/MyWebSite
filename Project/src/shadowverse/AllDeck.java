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

import beans.DeckDataBeans;
import dao.DeckDAO;

/**
 * Servlet implementation class AllDeck
 */
@WebServlet("/AllDeck")
public class AllDeck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllDeck() {
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
			DeckDAO deckdao=new DeckDAO();
			List<DeckDataBeans> AllDeckList = deckdao.findAllDeckInfo();

			request.setAttribute("AllDeckList", AllDeckList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/alldeck.jsp");
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
			String deckName=request.getParameter("deckName");
			String className=request.getParameter("className");

			DeckDAO deckdao = new DeckDAO();
			List<DeckDataBeans>  AllDeckList = deckdao.findAllDeckSearch(deckName, className);

		 	request.setAttribute("AllDeckList",AllDeckList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/alldeck.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
