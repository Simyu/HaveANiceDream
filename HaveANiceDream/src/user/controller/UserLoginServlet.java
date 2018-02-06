package user.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
			
		} else if (logtype.equals("Kakao") || logtype.equals("Naver")) {
			id = request.getParameter("kakaoNnaverid");
			user = service.userSelect(id);
		}

		if (user != null) {
			HttpSession session = request.getSession();
			SimpleDateFormat format = new SimpleDateFormat("MM:dd");
			if (!format.format(user.getUserLastLoginTime()).equals(new Date())){
				session.setAttribute("attFlag", false);
			} else {
				Cookie[] cookies = request.getCookies();
				String flag = "";
				
				for (int i = 0; i < cookies.length; i++) {
					if(cookies[i].getName().equals("attFlag")){
						flag = cookies[i].getValue();
					} 
				}
				
				if (flag.equals("T")){
					session.setAttribute("attFlag", true);
				} else {
					session.setAttribute("attFlag", false);
				}
			}
			
			session.setAttribute("user", user);
			String viewpath = "temp_main_con.jsp";

			new UserServiceImpl().userUpdateLoginTime(user.getUserId());

			request.setAttribute("viewpath", viewpath);
			url = "/main/main_layout.jsp";

		} else if (logtype.equals("Kakao") || logtype.equals("Naver")) {
			user = new MemberDTO();

			String kakaoNnaveremail = request.getParameter("kakaoNnaveremail");
			String kakaoNnaverimg = request.getParameter("kakaoNnaverimg");
			String kakaoNnavername = request.getParameter("kakaoNnavername");

			user.setUserId(id);
			user.setUserEmail(kakaoNnaveremail);
			user.setUserName(kakaoNnavername);
			user.setUserLogType(logtype);

			URL imgurl = new URL(kakaoNnaverimg);
			BufferedImage bufferedImage = ImageIO.read(imgurl);
			// 업로드 경로 구해오기
			String uploadpath = request.getSession().getServletContext().getRealPath("/uploadresources/user/");
			File file = new File(uploadpath + id + ".jpg");
			ImageIO.write(bufferedImage, "jpg", file);

			user.setUserImage(id + ".jpg");

			String viewpath = "../user/sign_in_page.jsp";

			request.setAttribute("kakaoNnaversignup", user);
			request.setAttribute("viewpath", viewpath);

			url = "/main/main_layout.jsp";
		} else {
			url = "/user/login.html";
		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);

	}

}
