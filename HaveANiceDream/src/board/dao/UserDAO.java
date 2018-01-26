package board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import user.dto.MemberDTO;

public interface UserDAO {
	int userInsert(MemberDTO user, Connection connection) throws SQLException;

	ArrayList<MemberDTO> userList(Connection connection) throws SQLException;

	MemberDTO userSelect(String userId, Connection connection) throws SQLException;

	MemberDTO userLogin(String userId, String userPw, Connection connection) throws SQLException;

	int userDelete(String userId, Connection connection) throws SQLException;

	int userUpdateType(String userId, String userType, Connection connection) throws SQLException;

	int userUpdatePoint(int pointTotal, String userId, Connection connection) throws SQLException;

	int userGetPoint(String userId, Connection connection) throws SQLException;

	int userUpdateLoginTime(String userId, Connection connection) throws SQLException;

	boolean idCheck(String userId, Connection connection) throws SQLException;

	int userUpdate(MemberDTO user, Connection connection) throws SQLException;
}
