package board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import user.dto.MemberDTO;

public interface BoardDAO {
	int boardInsert(BoardDTO boardwrite, Connection connection) throws SQLException;


}