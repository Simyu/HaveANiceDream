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


@WebServlet(name = "user/select", urlPatterns = { "/user/select.do" })
public class UserSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId");
		
		UserService service = new UserServiceImpl();
		MemberDTO dto = service.userSelect(userId);


		String viewpath = "../user/user_detail.jsp";

		request.setAttribute("viewpath", viewpath);
		request.setAttribute("user", dto);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
