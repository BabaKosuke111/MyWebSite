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
import beans.DeckDetailDataBeans;
import dao.DeckDetailDAO;

/**
 * Servlet implementation class DeckDetail
 */
@WebServlet("/DeckDetail")
public class DeckDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeckDetail() {
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

	 	DeckDetailDAO deckdetaildao=new DeckDetailDAO();
	 	DeckDataBeans deckdata=deckdetaildao.findDeck(deckId);
	 	List<DeckDetailDataBeans> deckDetailList=deckdetaildao.findById(deckId);

	 	request.setAttribute("deckdata", deckdata);
		request.setAttribute("deckDetailList", deckDetailList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deckdetail.jsp");
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
