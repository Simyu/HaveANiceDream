package product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.dto.ProductDTO;
import product.query.ProductState;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import user.dto.MemberDTO;

/**
 * Servlet implementation class Product_Enroll_Servlet
 */
@WebServlet(name = "product_enroll", urlPatterns = { "/product_enroll.do" })
public class Product_Enroll_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//ó���� ���� �⺻�۾�-�ѱۼ���,���䰴ü�� ���� ��Ʈ�� ���, ����Ÿ�� ����  
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		
		String saveFolder="/upload";
		String encType = "utf-8";
		int size = 5*1024*1024;
		String realFolder="";
		ServletContext context = getServletContext();
		realFolder = context.getRealPath(saveFolder);
	
	//	System.out.println(realFolder);
		ArrayList<String> filelist = new ArrayList<String>();
		MultipartRequest multipart = 
				new MultipartRequest(request,
						realFolder, size, encType, 
						new DefaultFileRenamePolicy());
		
		
		Enumeration<String> files =  multipart.getFileNames();
		String fileName = "";
		while(files.hasMoreElements()){
			String file = files.nextElement();
			fileName = multipart.getFilesystemName(file);
			filelist.add(fileName);
		}
		System.out.println(filelist);
		HttpSession ses = request.getSession(false);
		MemberDTO user = (MemberDTO) ses.getAttribute("user");
		int productPrice = Integer.parseInt(multipart.getParameter("productPrice"));
		int categoryNo = Integer.parseInt(multipart.getParameter("categoryNohidden"));
		int categoryDetailNo = Integer.parseInt(multipart.getParameter("categoryDetailNohidden"));
		//int categoryDetailNo = Integer.parseInt(multipart.getParameter("categoryDetailName"));
		String productName = multipart.getParameter("productName");
		String productTitle = multipart.getParameter("productTitle");
		String productContent = multipart.getParameter("productContent");
		String userId =  user.getUserId();
	//	System.out.println(userId);
		int productState =ProductState.TRADE_CURRENT;
		String productGrade = multipart.getParameter("productGrade");
			//���ŷ� �߰� 	
		String tradeType = multipart.getParameter("tradeType");
		
		//System.out.println(tradeType);
		//System.out.println(userId);
		//���δ�Ʈ �ѹ� ��ǰ��  ������ �ʿ���� ���ܿ���  �Ѱ�����
		//ProductDTO dto = new ProductDTO(productNo, userId, categoryNo, productName, productPrice, productContent, productCount, productTitle, productDate, productState, productExfDate, tradeType)
		
		ProductDTO product = new ProductDTO(userId,categoryNo, productName, productPrice, productContent,productGrade, productTitle, productState, tradeType,categoryDetailNo);

int result=0;
		ProductService service = new ProductServiceimpl();
			 result = service.insertProduct(product,filelist);
		
		System.out.println(result);
		String url="";
		String viewpath = request.getParameter("url");

		request.setAttribute("viewpath", viewpath);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
		
		
		
	}

}
