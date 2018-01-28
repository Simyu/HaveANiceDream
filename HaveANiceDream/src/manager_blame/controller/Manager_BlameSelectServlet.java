package manager_blame.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
		
		
		JSONObject json = new JSONObject();
		json.put("answerTitle", dto.getAnswerTitle());
		json.put("answerContent", dto.getAnswerContent());
		json.put("answerDate", dto.getAnswerDate());
		
		  PrintWriter pw = response.getWriter();
	         pw.println(json.toJSONString());
	         System.out.println(answerno);
	}

}
