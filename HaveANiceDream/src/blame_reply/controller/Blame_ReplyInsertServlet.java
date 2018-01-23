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


@WebServlet(name = "blame_reply/insert", urlPatterns = {"/blame_reply/insert.do"})
public class Blame_ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String blame_replyType = request.getParameter("blame_replyType");
		String blame_replyTitle = request.getParameter("blame_replyTitle");
		String blame_replyContent = request.getParameter("blame_replyContent");
		
		Blame_ReplyDTO reply = new Blame_ReplyDTO(blame_replyType, blame_replyTitle, blame_replyContent);
		Blame_ReplySerivce service = new Blame_ReplyServiceimpl();
		int result = service.insert(reply);
		
		if(result>0){
			response.sendRedirect("/HaveANiceDream/blame/list.do");
		}else{
			String viewpath = "../blame/Answer_list.jsp";
			request.setAttribute("viewpath", viewpath);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
