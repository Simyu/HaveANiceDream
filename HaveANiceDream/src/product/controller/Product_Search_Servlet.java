package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;

/**
 * Servlet implementation class Product_Search_Servlet
 */
@WebServlet(name = "product_search", urlPatterns = { "/product_search.do" })
public class Product_Search_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		int  productNo = Integer.parseInt(request.getParameter("productNo"));
		
		ProductService service = new ProductServiceimpl();
		ProductDTO product = service.productSelect(productNo);
		String fileName =service.productSelect_Image(productNo);
		
		
		String viewpath="../product/product_buy.jsp";
		System.out.println(product);
		request.setAttribute("product", product);
		request.setAttribute("viewpath", viewpath);

		request.setAttribute("file1", fileName);
		
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		
		
	}

}
