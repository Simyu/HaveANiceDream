package user.dao;

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
	int userTypeUpdate(String userId, String userType, Connection connection) throws SQLException;
}
