package reply.service;

import java.util.ArrayList;

import board.dto.BoardDTO;
import reply.dto.ReplyDTO;


public interface ReplyService {
	int replyInsert(ReplyDTO replywrite);
	
	ArrayList<BoardDTO> boardList();
	
	BoardDTO boardRead(int boardNo);
	
	int boardDelete(int boardNo);
}
