package blame.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blame.dto.BlameDTO;
import blame.service.BlameService;
import blame.service.BlameServiceimpl;

@WebServlet(name = "blame/select", urlPatterns = { "/blame/select.do" })
public class BlameSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int blameNo = Integer.parseInt(request.getParameter("blameNo"));
		
		BlameService service = new BlameServiceimpl();
		BlameDTO dto = service.select(blameNo);
		
		String viewpath = "../blame/reportview_center.jsp";
		
		request.setAttribute("viewpath", viewpath);
		request.setAttribute("blame", dto);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
