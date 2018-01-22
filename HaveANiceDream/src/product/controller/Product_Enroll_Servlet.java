package product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.ProductDTO;
import product.ProductState;
import product.service.ProductService;
import product.service.ProductServiceimpl;

/**
 * Servlet implementation class Product_Enroll_Servlet
 */
@WebServlet(name = "product_enroll", urlPatterns = { "/product_enroll.do" })
public class Product_Enroll_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//ó���� ���� �⺻�۾�-�ѱۼ���,���䰴ü�� ���� ��Ʈ�� ���, ����Ÿ�� ����  
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		String productName = request.getParameter("productName");
		String productTitle = request.getParameter("productTitle");
		String productContent = request.getParameter("productContent");
		String userId = request.getParameter("userId");
		int productState =ProductState.TRADE_CURRENT;
		String productGrade = request.getParameter("productGrade");
			//���ŷ� �߰� 	
		String tradeType = request.getParameter("tradeType");
				
		System.out.println(tradeType);
		System.out.println(userId);
		//���δ�Ʈ �ѹ� ��ǰ��  ������ �ʿ���� ���ܿ���  �Ѱ�����
		//ProductDTO dto = new ProductDTO(productNo, userId, categoryNo, productName, productPrice, productContent, productCount, productTitle, productDate, productState, productExfDate, tradeType)
		
		ProductDTO product = new ProductDTO(userId, productName, productPrice, productContent,productGrade, productTitle, productState, tradeType);
		
		PrintWriter pw = response.getWriter();
				
			ProductService service = new ProductServiceimpl();
			int result = service.insertProduct(product);
		
		String url="";
		String viewpath = request.getParameter("url");

		request.setAttribute("viewpath", viewpath);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
		
		
		
	}

}
