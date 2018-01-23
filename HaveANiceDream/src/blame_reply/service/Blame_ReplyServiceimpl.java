package blame_reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import static fw.DBUtil.*;
import blame_reply.dao.Blame_ReplyDAO;
import blame_reply.dao.Blame_ReplyDAOimpl;
import blame_reply.dto.Blame_ReplyDTO;

public class Blame_ReplyServiceimpl implements Blame_ReplySerivce {

	public int insert(Blame_ReplyDTO dto){
		Connection con = null;
		int result = 0;
		Blame_ReplyDAO dao = new Blame_ReplyDAOimpl();
		try {
			con = getConnect();
			result = dao.insert(dto, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(con);
		}
		return result;
	}

	public Blame_ReplyDTO select(int blame_replyNo){
		Blame_ReplyDTO result = null;
		Connection con = null;
		Blame_ReplyDAO dao = new Blame_ReplyDAOimpl();
		try {
			con = getConnect();
			result = dao.select(blame_replyNo, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(con);
		}
		return result;
	}

}
