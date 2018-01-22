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
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String state = req.getParameter("state");
		blamelist = service.list();
		String viewpath = "";
		if(state.equals("1")){
			viewpath = "../blame/report_list.jsp";
		}else{
			viewpath = "../blame/report_list_center.jsp";
		}
		
		
		req.setAttribute("viewpath", viewpath);
		req.setAttribute("blamelist", blamelist);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(req, res);
	}

}
