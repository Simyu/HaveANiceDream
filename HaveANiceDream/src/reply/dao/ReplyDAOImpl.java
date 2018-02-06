package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import board.query.BoardQuery;
import fw.DBUtil;
import reply.dto.ReplyDTO;
import reply.query.ReplyQuery;
import user.query.UserQuery;


public class ReplyDAOImpl implements ReplyDAO {

	@Override
	public int replyInsert(ReplyDTO replywrite, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(ReplyQuery.REPLY_INSERT);
		//insert into reply values(reply_seq.nextval,?,?,?,sysdate)

		preparedStatement.setInt(1, replywrite.getBorderNo());
		preparedStatement.setString(2, replywrite.getReplyContent());
		preparedStatement.setString(3, replywrite.getUserId());


		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<BoardDTO> boardList(Connection connection) throws SQLException {
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(BoardQuery.BOARD_LIST);
		
		rs = ptmt.executeQuery();
		
		while (rs.next()){
			dto = new BoardDTO(rs.getInt(1), rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),
					rs.getInt(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13));
			boardlist.add(dto);
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return boardlist;
	}

	@Override
	public BoardDTO boardRead(int boardNo, Connection connection) throws SQLException {
		BoardDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(BoardQuery.BOARD_READ);
		
		ptmt.setInt(1, boardNo);
		
		rs = ptmt.executeQuery();
		
		if(rs.next()){
			dto = new BoardDTO(rs.getInt(1), rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),
					rs.getInt(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13));
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return dto;
	}

	@Override
	public int boardDelete(int boardNo, Connection connection) throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(BoardQuery.BOARD_DELETE);


		preparedStatement.setInt(1, boardNo);

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}



}