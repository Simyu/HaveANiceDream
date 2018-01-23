package blame_reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import blame_reply.dto.Blame_ReplyDTO;

public interface Blame_ReplySerivce {
	int insert(Blame_ReplyDTO dto);
	Blame_ReplyDTO select(int blame_replyNo);
}
