package user.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/insert", urlPatterns = { "/user/insert.do" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String saveFolder = "/uploadresources/user";
		String encType = "utf-8";
		int size = 5 * 1024 * 1024;// (5mb)
		String realPath = "";
		
		ServletContext context = getServletContext();
		realPath = context.getRealPath(saveFolder);
		
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, size, encType,
				new DefaultFileRenamePolicy());
		
		String userId = multipartRequest.getParameter("userId");
		String userPw = multipartRequest.getParameter("userPw");
		String userEmail = multipartRequest.getParameter("userEmail1") + multipartRequest.getParameter("userEmail2");
		String userName = multipartRequest.getParameter("userName");
		String userZipcode = multipartRequest.getParameter("userZipcode");
		String userAddr = multipartRequest.getParameter("userAddr1");
		String userAddrDetail = multipartRequest.getParameter("userAddr2");
		String userTel = multipartRequest.getParameter("userTel1") + "-" + multipartRequest.getParameter("userTel2") + "-"
				+ multipartRequest.getParameter("userTel3");

		String fileNeme = "ui-sam.jpg";
		@SuppressWarnings("unchecked")
		Enumeration<String> files = multipartRequest.getFileNames();
		if (files.hasMoreElements()) {
			String file = files.nextElement();
			fileNeme = multipartRequest.getFilesystemName(file);
		}

		MemberDTO user = new MemberDTO(userId, userPw, userEmail, userName, userZipcode, userAddr, userAddrDetail,
				userTel, fileNeme);
		System.out.println(user);
		UserService service = new UserServiceImpl();
		int res = service.userInsert(user);

		if (res > 0) {
			response.sendRedirect("/HaveANiceDream/user/login.html");
		} else {

			String viewpath = "../user/sig_in_page.jsp";

			request.setAttribute("viewpath", viewpath);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
