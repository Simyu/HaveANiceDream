package blame_reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import blame.query.BlameQuery;
import blame_reply.dto.Blame_ReplyDTO;
import blame_reply.query.Blame_ReplyQuery;
import fw.DBUtil;

public class Blame_ReplyDAOimpl implements Blame_ReplyDAO {

	public int insert(Blame_ReplyDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(Blame_ReplyQuery.BLAME_INSERT);
		
		ptmt.setInt(1, dto.getBlame_replyNo());
		ptmt.setString(2, dto.getBlame_replyTitle());
		ptmt.setString(3, dto.getBlame_replyContent());
		ptmt.setDate(4, dto.getBlame_replyDate());
		ptmt.setString(5, dto.getBlame_replyType());
		
		result = ptmt.executeUpdate();
		return result;
	}

	public Blame_ReplyDTO select(int blame_replyNo, Connection con) throws SQLException {
		Blame_ReplyDTO dto = null;
		PreparedStatement ptmt=null;
		ResultSet rs = null;
		ptmt = con.prepareStatement(Blame_ReplyQuery.BLAME_SELECT);
		ptmt.setInt(1, blame_replyNo);
		
		rs = ptmt.executeQuery();
		if(rs.next()){
			dto = new Blame_ReplyDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDate(4),
					rs.getString(5)
					);
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		return null;
	}

}
