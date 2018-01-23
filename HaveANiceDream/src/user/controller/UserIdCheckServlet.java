package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/idcheck", urlPatterns = { "/user/idcheck.do" })
public class UserIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter printWriter = response.getWriter();

		String userId = request.getParameter("userId");

		UserService service = new UserServiceImpl();

		if (service.idCheck(userId)) {
			printWriter.println("이미 존재하는 ID입니다.");
		} else {
			printWriter.println("사용하실 수 있는 ID입니다.");
		}

	}

}
