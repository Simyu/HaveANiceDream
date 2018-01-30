package trade.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import trade.dto.TradeDTO;
import user.dto.MemberDTO;

public interface TradedDAO {
	int tradeInsert(TradeDTO tradelist, Connection connection) throws SQLException;
}
