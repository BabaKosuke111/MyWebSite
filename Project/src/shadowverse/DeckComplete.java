package shadowverse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeckDataBeans;
import beans.DeckDetailDataBeans;
import beans.UserDataBeans;
import dao.DeckDAO;
import dao.DeckDetailDAO;

/**
 * Servlet implementation class DeckComplete
 */
@WebServlet("/DeckComplete")
public class DeckComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeckComplete() {
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
			String deckname=request.getParameter("deckname");
			String classId=request.getParameter("classId");
			UserDataBeans userInfo=(UserDataBeans)session.getAttribute("userInfo");
			int userId=userInfo.getId();


			String[] carddeckId=request.getParameterValues("carddeckId");
			String[] cardCount=request.getParameterValues("cardCount");
			DeckDataBeans ddb=new DeckDataBeans();
			ddb.setDeckName(deckname);
			ddb.setClassId(classId);
			ddb.setUserId(userId);

			int deckId=DeckDAO.insertDeck(ddb);
			ArrayList<DeckDetailDataBeans> dddbList=new ArrayList<DeckDetailDataBeans>();
			for(int i=0;i<carddeckId.length;i++) {
				DeckDetailDataBeans dddb=new DeckDetailDataBeans();
				DeckDetailDAO deckdetaildao=new DeckDetailDAO();
				DeckDetailDataBeans carddata=deckdetaildao.cardSelectList(carddeckId[i]);
				dddb.setDeckId(deckId);
				dddb.setCardId(Integer.parseInt(carddeckId[i]));
				dddb.setCardCount(Integer.parseInt(cardCount[i]));
				dddb.setCardName(carddata.getCardName());
				dddbList.add(dddb);
				DeckDetailDAO.insertDeckDetail(dddb);
			}
			request.setAttribute("deckname", deckname);
			request.setAttribute("classId", classId);
			request.setAttribute("dddbList", dddbList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deckcomplete.jsp");
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
