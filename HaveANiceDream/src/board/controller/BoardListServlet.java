package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardService;
import board.service.BoardServiceImpl;


@WebServlet(name = "board/list", urlPatterns = { "/board/list.do" })
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = new BoardServiceImpl();
		ArrayList<BoardDTO> boardlist = null;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html/charset-utf-8");

		
		String viewpath = request.getParameter("url");
		
		
		boardlist = service.boardList();
		request.setAttribute("boardlist", boardlist);
		
		
		
		request.setAttribute("viewpath", viewpath);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
		
	
	}

}
