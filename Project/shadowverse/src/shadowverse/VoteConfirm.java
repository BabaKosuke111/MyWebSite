package shadowverse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeckDataBeans;
import dao.DeckDAO;
import dao.DeckDetailDAO;

/**
 * Servlet implementation class VoteConfirm
 */
@WebServlet("/VoteConfirm")
public class VoteConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			int voteId=Integer.parseInt( request.getParameter("voteId"));
			String deckId= request.getParameter("voteId");

			DeckDetailDAO deckdetaildao=new DeckDetailDAO();
			DeckDataBeans deckdata=deckdetaildao.findDeck(deckId);

			request.setAttribute("deckdata", deckdata);

			DeckDAO deckdao=new DeckDAO();
			deckdao.DeckVote(voteId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/voteconfirm.jsp");
			dispatcher.forward(request, response);


		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
