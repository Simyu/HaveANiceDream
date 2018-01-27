package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardService;
import board.service.BoardServiceImpl;
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
		String boardimageSrc = request.getParameter("boardImg");
		
		
		BoardDTO boardwrite = new BoardDTO(userId, boardTitle, boardContent, "답변대기", 0, 0, 0, 0, boardimageSrc, boardType1, boardType2);
		System.out.println(boardwrite);
		
		BoardService service = new BoardServiceImpl();
		int res = service.boardInsert(boardwrite);

		if (res > 0) {
			
			String viewpath = "../board/board_list.jsp";

			request.setAttribute("viewpath", viewpath);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		} else {

			String viewpath = "../board/board_write.jsp";

			request.setAttribute("viewpath", viewpath);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		}
	} 

}