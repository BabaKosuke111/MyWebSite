package shadowverse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class UserDataUpdate
 */
@WebServlet("/UserDataUpdate")
public class UserDataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataUpdate() {
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
			// リクエストパラメータの入力項目を取得
			UserDataBeans userInfo=(UserDataBeans)session.getAttribute("userInfo");

			int userId=userInfo.getId();
			String inputUserName = request.getParameter("name");
			String inputUserAddress = request.getParameter("address");
			String inputPassword = request.getParameter("password");


			UserDataBeans udb = new UserDataBeans();
			udb.setName(inputUserName);
			udb.setAddress(inputUserAddress);
			udb.setPassword(inputPassword);

			String confirmed = request.getParameter("confirm_button");

			switch (confirmed) {
			case "cancel":
				request.setAttribute("udb", udb);
				response.sendRedirect("UserData");
				break;

			case "update":
				request.setAttribute("udb", udb);

				session.removeAttribute("userInfo");

				UserDAO userdao=new UserDAO();
				userdao.UserUpdate(userId,inputUserName,inputUserAddress,inputPassword);

				UserDataBeans userdatabeans = userdao.findByLoginInfo(inputUserAddress,inputPassword);

				session.setAttribute("userInfo", userdatabeans);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdataupdate.jsp");
				dispatcher.forward(request, response);
				break;
			}


		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
