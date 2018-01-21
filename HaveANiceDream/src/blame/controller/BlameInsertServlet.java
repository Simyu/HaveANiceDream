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


@WebServlet(name = "blame/insert", urlPatterns = {"/blame/insert.do"})
public class BlameInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String blameType = request.getParameter("blameType");
		String userIdBlamere = request.getParameter("userIdBlamere");
		String userIdBlamee = request.getParameter("userIdBlamee");
		int productNo = Integer.parseInt(request.getParameter("productNo"));  
		String attachedFile = request.getParameter("attachedFile");
		String blameTitle = request.getParameter("blameTitle");
		String blameContent = request.getParameter("blameContent");
		
		BlameDTO blame = new BlameDTO(blameType,userIdBlamere,userIdBlamee,productNo,attachedFile,blameTitle,blameContent);
		BlameService service = new BlameServiceimpl();
		int result = service.insert(blame);
		
		if(result>0){
			response.sendRedirect("/HaveANiceDream/blame/reportview_report");
		}else{
			String viewpath = "../blame/report_boss.jsp";
			request.setAttribute("viewpath", viewpath);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		}
	
	}

}
