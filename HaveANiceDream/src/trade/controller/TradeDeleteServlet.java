package trade.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import point.service.PointService;
import point.service.PointServiceImpl;
import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.service.UserService;
import user.service.UserServiceImpl;


@WebServlet(name = "trade/delete", urlPatterns = { "/trade/delete.do" })
public class TradeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession ses = request.getSession(false);
		
		String tradeNo = request.getParameter("tradeNo");

		TradeService tradeservice = new TradeServiceImpl();
		int result = 0;
		result = tradeservice.tradeDelete(Integer.parseInt(tradeNo));

		response.sendRedirect("/HaveANiceDream/trade/list.do");
	}

}
