package blame.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blame.dto.BlameDTO;
import blame.service.BlameService;
import blame.service.BlameServiceimpl;

@WebServlet(name = "blame/list", urlPatterns = { "/blame/list.do" })
public class BlameListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException, IOException{
		BlameService service = new BlameServiceimpl();
		ArrayList<BlameDTO> blamelist = null;
		ArrayList<BlameDTO> user_list = null;
		String useridblamere = req.getParameter("userIdBlamere");
						
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String state = req.getParameter("state");
		blamelist = service.list();
		user_list = service.user_list(useridblamere);
		String viewpath = "";
		if(state.equals("1")){
			viewpath = "../blame/report_list.jsp";
			req.setAttribute("user_list",user_list);
		}else{
			viewpath = "../blame/report_list_center.jsp";
			req.setAttribute("blamelist", blamelist);
		}
		
		req.setAttribute("viewpath", viewpath);
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(req, res);
	}

}
