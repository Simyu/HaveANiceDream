package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import user.dto.MemberDTO;

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
		
		
		HttpSession ses =  request.getSession(false);
		MemberDTO user =null;
		 String viewpath="";
		  viewpath="../product/product_buy.jsp";
		//프로덕트넘버의 값으로    
	/*	if(ses!=null){
			  user = (MemberDTO)ses.getAttribute("user");
			  String enrollId = product.getUserId();
			  if(user.equals(enrollId)){
				  viewpath="../product/product_buy.jsp";
			  }else{
				   viewpath="../Trade/trade_popup.jsp";
			  }
		};*/
		
		
		//else로그인화면
		System.out.println(product);
		request.setAttribute("product", product);
		request.setAttribute("viewpath", viewpath);

		request.setAttribute("file1", fileName);
		
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		
		
	}

}
