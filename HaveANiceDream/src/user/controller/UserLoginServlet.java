package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/login", urlPatterns = { "/user/login.do" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");

		String id = (String) request.getParameter("id");
		String pass = (String) request.getParameter("pass");

		UserService service = new UserServiceImpl();
		MemberDTO user = service.userLogin(id, pass);

		String url = null;
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String viewpath = "temp_main_con.jsp";
			
			new UserServiceImpl().userUpdateLoginTime(user.getUserId());

			request.setAttribute("viewpath", viewpath);
			url = "/main/main_layout.jsp";
		} else {
			url = "/user/login.html";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

}
