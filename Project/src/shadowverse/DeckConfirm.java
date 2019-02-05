package shadowverse;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class DeckConfirm
 */
@WebServlet("/DeckConfirm")
public class DeckConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeckConfirm() {
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
			String[] carddeckId=request.getParameterValues("carddeckId");
			String[] cardCount=request.getParameterValues("cardCount");
			int[] x = new int[cardCount.length];
			for (int i = 0; i < cardCount.length; i++) {
				x[i] = Integer.parseInt(cardCount[i]);
			}


			String validationMessage = "";

			if(sumOf(x)==10) {
				String deckname = request.getParameter("name");
				String classId=request.getParameter("classId");
				ArrayList<DeckDetailDataBeans> deckdetailList=new ArrayList<DeckDetailDataBeans>();
				for(int i=0;i<carddeckId.length;i++) {
					if(Integer.parseInt(cardCount[i])>0) {
						DeckDetailDataBeans deckdetail=new DeckDetailDataBeans();
						DeckDetailDAO deckdetaildao=new DeckDetailDAO();
						DeckDetailDataBeans carddata=deckdetaildao.cardSelectList(carddeckId[i]);
						deckdetail.setCardId(Integer.parseInt(carddeckId[i]));
						deckdetail.setCardCount(Integer.parseInt(cardCount[i]));
						deckdetail.setCardName(carddata.getCardName());
						deckdetailList.add(deckdetail);


					}
				}
				request.setAttribute("deckname", deckname);
				request.setAttribute("classId", classId);
				request.setAttribute("deckdetailList", deckdetailList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deckconfirm.jsp");
				dispatcher.forward(request, response);
			}else {
				validationMessage += "カードの枚数を合計で10枚にしてください<br>";
				String deckname = request.getParameter("name");
				String classId= request.getParameter("classId");
				DeckDetailDAO deckdetaildao=new DeckDetailDAO();
				List<DeckDetailDataBeans> cardselectList=deckdetaildao.ClassSelectList(classId);
				request.setAttribute("classId", classId);
				request.setAttribute("deckname", deckname);
				request.setAttribute("cardselectList", cardselectList);
				request.setAttribute("validationMessage", validationMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardselect.jsp");
				dispatcher.forward(request, response);

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


	public static int sumOf(int... integers) {
		int total = 0;
		for (int i = 0; i < integers.length; total += integers[i++]);
		return total;
	}
}
