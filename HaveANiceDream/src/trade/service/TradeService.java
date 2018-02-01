package trade.service;

import java.util.ArrayList;

import board.dto.BoardDTO;
import trade.dto.TradeDTO;


public interface TradeService {
	int tradeInsert(TradeDTO tradelist);
	ArrayList<TradeDTO> tradeSelect(String userId);
	TradeDTO tradenoSelect(int tradeNo);
}
