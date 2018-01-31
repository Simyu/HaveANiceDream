package user.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/login", urlPatterns = { "/user/login.do" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String logtype = request.getParameter("logtype");
		String id = null;
		String url = null;

		UserService service = new UserServiceImpl();
		MemberDTO user = null;
		
		if (logtype.equals("기본")) {
			id = request.getParameter("id");
			String pass = request.getParameter("pass");
			user = service.userLogin(id, pass);
			
		} else if (logtype.equals("Kakao")) {
			id = request.getParameter("kakaoid");
			user = service.userSelect(id);
		}

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String viewpath = "temp_main_con.jsp";

			new UserServiceImpl().userUpdateLoginTime(user.getUserId());

			request.setAttribute("viewpath", viewpath);
			url = "/main/main_layout.jsp";

		} else if (logtype.equals("Kakao")) {
			user = new MemberDTO();

			String kakaoemail = request.getParameter("kakaoemail");
			String kakaoimg = request.getParameter("kakaoimg");
			String kakaoname = request.getParameter("kakaoname");

			user.setUserId(id);
			user.setUserEmail(kakaoemail);
			user.setUserName(kakaoname);
			user.setUserLogType(logtype);

			URL imgurl = new URL(kakaoimg);
			BufferedImage bufferedImage = ImageIO.read(imgurl);
			// 업로드 경로 구해오기
			String uploadpath = request.getSession().getServletContext().getRealPath("/uploadresources/user/");
			File file = new File(uploadpath + id + ".jpg");
			ImageIO.write(bufferedImage, "jpg", file);

			user.setUserImage(id + ".jpg");

			String viewpath = "../user/sign_in_page.jsp";

			request.setAttribute("kakaosignup", user);
			request.setAttribute("viewpath", viewpath);

			url = "/main/main_layout.jsp";
		} else {
			url = "/user/login.html";
		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);

	}

}
