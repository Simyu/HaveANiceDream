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
		 int categoryNo =0;
		 int categoryDetailNo =0;

		 String title=request.getParameter("title");
		 ArrayList<ProductDTO>  productlist = null;
		 ArrayList<CategoryDTO>  category_list = null;
		 String viewpath="";
		 if(state.equals("ALL")){
		  productlist = service.product_List(null,categoryNo,categoryDetailNo);

		  viewpath  = "../product/product_list.jsp";
		 }else if(state.equals("SEARCH")){
			 //numberFOrma 예외처리해주어야합니다.
		
				 if(request.getParameter("categoryNo").equals("선택해주세요")){
					 productlist = service.product_List(title,0,0);
					  viewpath  = "../product/product_list.jsp";
				 }else if(request.getParameter("categoryDetailNohidden").equals("선택해주세요")){//첫번쨰거만 입력하고 두번째꺼 안입력햇을ㄸ때

					 categoryNo =Integer.parseInt(request.getParameter("categoryNohidden"));
					 productlist = service.product_List(title,categoryNo,0);
					// String test= request.getParameter("categoryDetailNo");
					// String test1= request.getParameter("categoryDetailNohidden");
					// System.out.println("서블릿 셀렉트태그로부터 넘어오는값 디테일넘버"+test);
					// System.out.println("서블릿 히든으로부터 넘어오는값"+test1);
					 viewpath  = "../product/product_list.jsp";
				 }else{//정상입력
					// String test= request.getParameter("categoryDetailNo");
					// String test1= request.getParameter("categoryDetailNohidden");
					// System.out.println("서블릿 셀렉트태그로부터 넘어오는값"+test);
					// System.out.println("서블릿 히든으로부터 넘어오는값"+test1);
					 categoryNo =Integer.parseInt(request.getParameter("categoryNohidden"));
					 categoryDetailNo = Integer.parseInt(request.getParameter("categoryDetailNo"));
					 productlist = service.product_List(title,categoryNo,categoryDetailNo);
					 viewpath  = "../product/product_list.jsp";
				 }
				// System.out.println(productlist);
			 }
		  category_list = service1.categoryList(null);
			request.setAttribute("viewpath", viewpath);
			request.setAttribute("productlist", productlist);
		 
		 request.setAttribute("category_list", category_list);
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		
	}

}
