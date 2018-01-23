package blame_reply.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blame_reply.dto.Blame_ReplyDTO;
import blame_reply.service.Blame_ReplySerivce;
import blame_reply.service.Blame_ReplyServiceimpl;

@WebServlet(name = "blame_reply/select", urlPatterns = { "/blame_reply/select.do" })
public class Blame_ReplySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int blame_replyNo = Integer.parseInt(request.getParameter("blame_replyNo"));
		
		Blame_ReplySerivce service = new Blame_ReplyServiceimpl();
		Blame_ReplyDTO dto = service.select(blame_replyNo);
		
		String viewpath = "../blame/reportview_center.jsp";
		
		request.setAttribute("viewpath", viewpath);
		request.setAttribute("blame_reply", dto);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
