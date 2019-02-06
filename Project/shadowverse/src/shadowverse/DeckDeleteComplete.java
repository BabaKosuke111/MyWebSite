package shadowverse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeckDAO;

/**
 * Servlet implementation class DeckDeleteComplete
 */
@WebServlet("/DeckDeleteComplete")
public class DeckDeleteComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeckDeleteComplete() {
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
			String deckId=request.getParameter("deckId");

			String confirmed = request.getParameter("confirm_button");

			switch (confirmed) {
			case "cancel":
				response.sendRedirect("AllDeck");
				break;

			case "delete":
			DeckDAO deckdao=new DeckDAO();
			deckdao.DeleteDeckInfo(deckId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deckdeletecomplete.jsp");
			dispatcher.forward(request, response);
			break;
			}
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
