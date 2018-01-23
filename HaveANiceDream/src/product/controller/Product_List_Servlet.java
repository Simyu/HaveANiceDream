package product.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Product_List_Servlet
 */
@WebServlet(name = "product_list", urlPatterns = { "/product_list.do" })
public class Product_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		 ProductService service= new ProductServiceimpl();
		 ArrayList<ProductDTO>  productlist = service.product_List();
		// System.out.println(productlist);
		 
		 String viewpath = "../product/product_list.jsp";

			request.setAttribute("viewpath", viewpath);
			request.setAttribute("productlist", productlist);
		 
		 
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		
	}

}
