package manager_blame.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager_blame.dto.Manager_BlameDTO;
import manager_blame.service.Manager_BlameService;
import manager_blame.service.Manager_BlameServiceimpl;

@WebServlet(name = "manager_blame/select", urlPatterns = { "/manager_blame/select.do" })
public class Manager_BlameSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int answerno = Integer.parseInt(request.getParameter("answerNo"));
		
		Manager_BlameService service = new Manager_BlameServiceimpl();
		Manager_BlameDTO dto = service.select(answerno);
		
		String viewpath = "../blame/report_list_center.jsp";
		
		request.setAttribute("viewpath", viewpath);
		request.setAttribute("blame_reply", dto);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
