package trade.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.dto.MemberDTO;


@WebServlet(name = "trade/insert", urlPatterns = { "/trade/insert.do" })
public class TradeInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//해당 서블릿에서 구현할 사항
		//거래요청이 들어오면 구매자,판매자에게 문자전송
		//물품리스트에서 (list서블릿에서 숨김기능)
		//마이페이지에서 거래진행상황보이게 띄우기.. 
		/*	 public static int  TRADE_CURRENT = 1; //거래중
	 public static int  TRADE_END = 2;//거래종료   인 경우 마이페이지에서 확인이 가능해야함...  따라서 거래가 신청이 들어오면 현재상태를 변경하여 마이페이지에서 거래 상태 화면이 떠야함..
	 거래상태를 변경시키는 업데이트 메소드
		 * */
		
		ProductService proservice = new ProductServiceimpl();
		HttpSession ses = request.getSession(false);
		String thisProduct=request.getParameter("productNo");

		String viewpath="";
		

		if(ses!=null){
			TradeService tradeservice = new TradeServiceImpl();
			ProductDTO productdto = new ProductDTO();
			MemberDTO user = (MemberDTO) ses.getAttribute("user");
			String userId= user.getUserId();
			productdto = proservice.productSelect(Integer.parseInt(thisProduct));
			
			 
			 
			 TradeDTO tradedto = new TradeDTO(null, null, null, userId, productdto.getUserId(), productdto.getProductNo(), "거래대기");
			 int rowNum = tradeservice.tradeInsert(tradedto);
			 
			 
			 
	
		}else{
			viewpath="../user/login.html";
		}
		
		
		//System.out.println("서블릿... ^^"+productlist);
		
		
		request.setAttribute("viewpath", viewpath);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
