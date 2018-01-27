package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.CategoryDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;
import product.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;

/**
 * Servlet implementation class Product_List_Servlet
 */
@WebServlet(name = "product_list", urlPatterns = { "/product_list.do" })
public class Product_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		 ProductService service= new ProductServiceimpl();
		 CategoryService service1 = new CategoryServiceimpl();
		 String state = request.getParameter("state");
		
		 String title=request.getParameter("title");
		 ArrayList<ProductDTO>  productlist = null;
		 ArrayList<CategoryDTO>  category_list = null;
		 String viewpath="";
		 if(state.equals("ALL")){
		  productlist = service.product_List(null);
		  category_list = service1.categoryList(null);
		  viewpath  = "../product/product_list.jsp";
		 }else if(state.equals("SEARCH")){
			 productlist = service.product_List(title);
			 System.out.println(title);
			  viewpath  = "../product/product_list.jsp";

				// System.out.println(productlist);
			 }

			request.setAttribute("viewpath", viewpath);
			request.setAttribute("productlist", productlist);
		 
		 request.setAttribute("category_list", category_list);
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		
	}

}
