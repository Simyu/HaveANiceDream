package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import user.MemberDTO;
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

public class UserDAOImpl implements UserDAO {

	@Override
	public int userInsert(MemberDTO user) {
		int rowNum = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(UserQuery.USER_INSERT);
			// "insert into member values(?,?,?,?,?,?,?,sysdate,?,sysdate,?,?)";

			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getUserPw());
			preparedStatement.setString(3, user.getUserEmail());
			preparedStatement.setString(4, user.getUserName());
			preparedStatement.setString(5, user.getUserZipcode());
			preparedStatement.setString(6, user.getUserAddr());
			preparedStatement.setString(7, user.getUserTel());
			preparedStatement.setString(8, user.getUserLogType());
			preparedStatement.setInt(9, user.getPointTotal());
			preparedStatement.setString(10, user.getUserType());

			rowNum = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}

		return rowNum;
	}

	@Override
	public ArrayList<MemberDTO> userList() {
		ArrayList<MemberDTO> list = null;
		MemberDTO dto = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(UserQuery.USER_LIST);
			//"select * from member";

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (list == null) {
					list = new ArrayList<MemberDTO>();
				}

				dto = new MemberDTO(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3),
						resultSet.getString(4), 
						resultSet.getString(5), 
						resultSet.getString(6), 
						resultSet.getString(7),
						resultSet.getDate(8), 
						resultSet.getString(9), 
						resultSet.getDate(10), 
						resultSet.getInt(11),
						resultSet.getString(12)
						);

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}

		return list;
	}

	@Override
	public MemberDTO userSelect(String userId) {
		MemberDTO dto = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(UserQuery.USER_SELECT);
			//"select * from member where USER_ID = ?";
			
			preparedStatement.setString(1, userId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				dto = new MemberDTO(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3),
						resultSet.getString(4), 
						resultSet.getString(5), 
						resultSet.getString(6), 
						resultSet.getString(7),
						resultSet.getDate(8), 
						resultSet.getString(9), 
						resultSet.getDate(10), 
						resultSet.getInt(11),
						resultSet.getString(12)
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}

		return dto;
	}

	@Override
	public MemberDTO userLogin(String userId, String userPw) {
		MemberDTO dto = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(UserQuery.USER_LOGIN);
			//"select * from member where USER_ID = ? and USER_PW = ?";
			
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				dto = new MemberDTO(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3),
						resultSet.getString(4), 
						resultSet.getString(5), 
						resultSet.getString(6), 
						resultSet.getString(7),
						resultSet.getDate(8), 
						resultSet.getString(9), 
						resultSet.getDate(10), 
						resultSet.getInt(11),
						resultSet.getString(12)
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}

		return dto;
	}

}
