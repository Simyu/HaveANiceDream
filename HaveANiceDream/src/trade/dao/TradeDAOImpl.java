package trade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import board.query.BoardQuery;
import fw.DBUtil;
import trade.dto.TradeDTO;
import trade.query.TradeQuery;
import user.query.UserQuery;


public class TradeDAOImpl implements TradedDAO {

	@Override
	public int tradeInsert(TradeDTO tradelist, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(TradeQuery.TRADE_INSERT);
		preparedStatement.setDate(1, tradelist.getTradeEndDate());
		preparedStatement.setString(2, tradelist.getUserIdBuy());
		preparedStatement.setString(3, tradelist.getUserIdSell());
		preparedStatement.setInt(4, tradelist.getProductNo());
		preparedStatement.setString(5, tradelist.getTradeState());

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<TradeDTO> tradeSelect(String userId, Connection connection) throws SQLException {
		ArrayList<TradeDTO> tradelist = new ArrayList<TradeDTO>();
		TradeDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(TradeQuery.TRADE_SELECT);

		ptmt.setString(1, userId);
		ptmt.setString(2, userId);
		
		rs = ptmt.executeQuery();
		
		
		while (rs.next()){
			dto = new TradeDTO(rs.getInt(1), rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			tradelist.add(dto);
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return tradelist;
	}
}