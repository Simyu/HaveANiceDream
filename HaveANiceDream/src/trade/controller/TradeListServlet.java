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
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.dto.MemberDTO;

@WebServlet(name = "trade/list", urlPatterns = { "/trade/list.do" })
public class TradeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession ses = request.getSession(false);
		
		String viewpath="";
		
		
		if(ses!=null){
			TradeService tradeservice = new TradeServiceImpl();
			ProductDTO productdto = new ProductDTO();
			MemberDTO user = (MemberDTO) ses.getAttribute("user");
			String userId= user.getUserId();
			ArrayList<TradeDTO> tradelist = tradeservice.tradeSelect(userId);
			System.out.println(tradelist);
			
			viewpath="../Trade/trade_list.jsp";
			request.setAttribute("tradelist", tradelist);
		}else{
			
			viewpath="../user/login.html";
			
		}
		
		request.setAttribute("viewpath", viewpath);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}
}
