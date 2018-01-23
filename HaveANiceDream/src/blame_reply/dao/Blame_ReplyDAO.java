package blame_reply.dao;

import java.sql.Connection;
import java.sql.SQLException;
import blame_reply.dto.Blame_ReplyDTO;

public interface Blame_ReplyDAO {
	int insert(Blame_ReplyDTO dto,Connection con) throws SQLException;
	Blame_ReplyDTO select(int blame_replyNo,Connection con) throws SQLException;
}
