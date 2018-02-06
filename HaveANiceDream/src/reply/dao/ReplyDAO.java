package reply.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import reply.dto.ReplyDTO;
import user.dto.MemberDTO;

public interface ReplyDAO {
	int replyInsert(ReplyDTO replywrite, Connection connection) throws SQLException;
	ArrayList<BoardDTO> boardList(Connection connection) throws SQLException;
	BoardDTO boardRead(int boardNo,Connection connection) throws SQLException;
	int boardDelete(int boardNo,Connection connection) throws SQLException;
}
