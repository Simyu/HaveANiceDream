package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import board.query.BoardQuery;
import fw.DBUtil;
import user.dto.MemberDTO;
import user.query.UserQuery;

/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
USER_ID                                   NOT NULL VARCHAR2(20)
USER_PW                                            VARCHAR2(20)
USER_EMAIL                                         VARCHAR2(20)
USER_NAME                                          VARCHAR2(20)
USER_ZIPCODE                                       VARCHAR2(5)
USER_ADDR                                          VARCHAR2(90)
USER_TEL                                           VARCHAR2(20)
USER_SIGDATE                                       DATE
USER_LOG_TYPE                                      VARCHAR2(20)
USER_LAST_LOGIN_TIME                               DATE
POINT_TOTAL                                        NUMBER
USER_TYPE                                          VARCHAR2(20)
*/

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int boardInsert(BoardDTO boardwrite, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(BoardQuery.BOARD_INSERT);
		// "insert into board values(board_seq.nextval,?,sysdate,?,?,0,0,0,0,0,?,?,?)";

		preparedStatement.setString(1, boardwrite.getUserId());
		preparedStatement.setString(2, boardwrite.getBoardTitle());
		preparedStatement.setString(3, boardwrite.getBoardContent());
		preparedStatement.setString(4, boardwrite.getBoardState());
		preparedStatement.setInt(5, boardwrite.getBoardCount());
		preparedStatement.setInt(6, boardwrite.getBoardParentNo());
		preparedStatement.setInt(7, boardwrite.getBoardLevel());
		preparedStatement.setInt(8, boardwrite.getBoardOrder());
		preparedStatement.setString(9, boardwrite.getBoardimageSrc());
		preparedStatement.setString(10, boardwrite.getBoardType1());
		preparedStatement.setString(11, boardwrite.getBoardType2());

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

}