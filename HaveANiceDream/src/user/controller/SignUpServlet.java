package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/insert", urlPatterns = { "/user/insert.do" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail1") + request.getParameter("userEmail2");
		String userName = request.getParameter("userName");
		String userZipcode = request.getParameter("userZipcode");
		String userAddr = request.getParameter("userAddr1") + " " + request.getParameter("userAddr2");
		String userTel = request.getParameter("userTel1") + "-" + request.getParameter("userTel2") + "-"
				+ request.getParameter("userTel3");

		MemberDTO user = new MemberDTO(userId, userPw, userEmail, userName, userZipcode, userAddr, userTel);
		UserService service = new UserServiceImpl();
		int res = service.userInsert(user);

		if (res > 0) {
			response.sendRedirect("/HaveANiceDream/user/login.html");
		} else {

			String viewpath = "../user/sig_in_page.jsp";

			request.setAttribute("viewpath", viewpath);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
