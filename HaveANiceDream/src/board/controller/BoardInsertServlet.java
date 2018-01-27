package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "border/insert", urlPatterns = { "/border/insert.do" })
public class BoardInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String boardType1 = request.getParameter("boardType1");
		String boardType2 = request.getParameter("boardType2");
		String boardImg = request.getParameter("boardImg");
		
		
		BoardDTO user = new BoardDTO(userId, boardTitle, boardContent, boardImg, boardType1, boardType2);
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