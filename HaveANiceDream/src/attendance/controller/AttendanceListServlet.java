package attendance.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.service.AttendanceService;
import attendance.service.AttendanceServiceimpl;
import user.dto.MemberDTO;

@WebServlet(name = "attendance/list", urlPatterns = { "/attendance/list.do" })
public class AttendanceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		HttpSession session = req.getSession(false);
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String userid = dto.getUserId();
		// System.out.println(userid);
		AttendanceService service = new AttendanceServiceimpl();
		ArrayList<Date> list = service.list(userid);
		//System.out.println(service);
		//System.out.println(userid);
		SimpleDateFormat format = new SimpleDateFormat("DD");
		// System.out.println(format);
		// System.out.println(format.format(list.get(0)));
		ArrayList<String> day = new ArrayList<String>();// --------------------문제 -< 여기가 null로뜸  될때도 잇고 null나올떄도있음

		for (int i = 0; i < list.size(); i++) {
			day.add(format.format(list.get(i)));
			//System.out.println(format.format(list.get(i)));
		}

		
		String viewpath = "";
		viewpath = "../attendance/project_calender.jsp";
		req.setAttribute("attdate", list);
		req.setAttribute("viewpath", viewpath);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(req, res);
	}

}