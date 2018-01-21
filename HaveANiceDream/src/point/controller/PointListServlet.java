package point.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;

@WebServlet(name = "point/list", urlPatterns = { "/point/list.do" })
public class PointListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = "leesuj1"; // session에서 가져오기
		
		PointService service = new PointServiceImpl();
		ArrayList<PointDTO> pointlist = service.pointList(userId);

		String viewpath = "../point/point_detail.jsp";

		request.setAttribute("viewpath", viewpath);
		request.setAttribute("pointlist", pointlist);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
