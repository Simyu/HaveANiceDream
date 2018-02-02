package trade.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;
import fw.DBUtil;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;
import product.dto.ProductDTO;
import trade.dao.TradeDAOImpl;
import trade.dao.TradeDAO;
import trade.dto.TradeDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.dto.MemberDTO;

public class TradeServiceImpl implements TradeService {

	@Override
	public int tradeInsert(TradeDTO tradelist) {
		Connection connection = null;
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();

			TradeDAO dao = new TradeDAOImpl();
			rowNum = dao.tradeInsert(tradelist, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public ArrayList<TradeDTO> tradeSelect(String userId) {
		Connection connection = null;
		ArrayList<TradeDTO> tradeList = null;
		
		
		try {
			connection = DBUtil.getConnect();
			TradeDAO dao = new TradeDAOImpl();
			tradeList = dao.tradeSelect(userId, connection);
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		
		return tradeList;
	}

	@Override
	public TradeDTO tradenoSelect(int tradeNo) {
		Connection connection = null;
		TradeDTO dto = null;
		
		try {
			connection = DBUtil.getConnect();
			TradeDAO dao = new TradeDAOImpl();
			dto = dao.tradenoSelect(tradeNo, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return dto;
	}

	@Override
	public int tradeStateUpdate(String tradeState, int tradeNo) {
		Connection connection = null;
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			TradeDAO dao = new TradeDAOImpl();
			result = dao.tradeStateUpdate(tradeState, tradeNo, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return result;
	}


}
