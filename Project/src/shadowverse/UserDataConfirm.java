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
import beans.UserDataBeans;
import dao.DeckDAO;
import dao.UserDAO;

/**
 * Servlet implementation class UserDataConfirm
 */
@WebServlet("/UserDataConfirm")
public class UserDataConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			UserDataBeans userInfo=(UserDataBeans)session.getAttribute("userInfo");

			int userId=userInfo.getId();

			DeckDAO deckdao=new DeckDAO();
			List<DeckDataBeans> userdeckList=deckdao.findUserDeckInfo(userId);

			request.setAttribute("userdeckList", userdeckList);

			// リクエストパラメータの入力項目を取得
			String inputUserName = request.getParameter("name");
			String inputUserAddress = request.getParameter("address");
			String inputPassword = request.getParameter("password");
			String inputCFPassword = request.getParameter("cfpassword");

			UserDataBeans udb = new UserDataBeans();
			udb.setName(inputUserName);
			udb.setAddress(inputUserAddress);
			udb.setPassword(inputPassword);
			UserDAO userdao=new UserDAO();
			UserDataBeans userdatabeans = userdao.findByNewLoginInfo(inputUserName,inputUserAddress);
			String validationMessage = "";

			if(userdatabeans!=null) {
				validationMessage += "すでに同じユーザ名もしくはアドレスが存在します<br>";

			}
			// 入力されているパスワードが確認用と等しいか
			if (!inputPassword.equals(inputCFPassword)) {
				validationMessage += "入力されているパスワードと確認用パスワードが違います<br>";
			}
			// バリデーションエラーメッセージがないなら確認画面へ
			if (validationMessage.length() == 0) {
				request.setAttribute("udb", udb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdataconfirm.jsp");
			dispatcher.forward(request, response);

			} else {
			request.setAttribute("udb", udb);
			request.setAttribute("validationMessage", validationMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdata.jsp");
			dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}


}
