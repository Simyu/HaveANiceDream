package trade.controller;

import java.io.IOException;
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


@WebServlet(name = "trade/stateupdate", urlPatterns = { "/trade/stateupdate.do" })
public class TradeStateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession ses = request.getSession(false);
		
		String tradeNo = request.getParameter("tradeNo");
		String productNo = request.getParameter("productNo");

		TradeService tradeservice = new TradeServiceImpl();
		TradeDTO tradedto = null;
		tradedto = tradeservice.tradenoSelect(Integer.parseInt(tradeNo));
		
		ProductService proservice = new ProductServiceimpl();
		ProductDTO productdto = null;
		productdto=proservice.productSelect(Integer.parseInt(productNo));
		
		int tradeStateUpdateResult = 0;
		int productStateUpdateResult = 0;
		if(tradedto.getTradeState().equals("거래대기")){
			tradeStateUpdateResult = tradeservice.tradeStateUpdate("거래중", Integer.parseInt(tradeNo));
			int productState=2;//거래중을 표시
			productStateUpdateResult = proservice.productStateUpdate(productState, Integer.parseInt(productNo));
		}else if(tradedto.getTradeState().equals("거래중")){
			tradeStateUpdateResult = tradeservice.tradeStateUpdate("거래완료", Integer.parseInt(tradeNo));
			int productState=1;//거래완료를 표시
			productStateUpdateResult = proservice.productStateUpdate(productState, Integer.parseInt(productNo));
		}
		
		
		
		
		
		response.sendRedirect("/HaveANiceDream/trade/list.do");
	}

}
