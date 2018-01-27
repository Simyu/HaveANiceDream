package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.dto.MemberDTO;

public class UserServiceImpl implements UserService {

	@Override
	public int userInsert(MemberDTO user) {
		Connection connection = null;
		int rowNum = 0;
		boolean state = false;

		try {
			connection = DBUtil.getConnect();
			connection.setAutoCommit(false);

			UserDAO dao = new UserDAOImpl();
			rowNum = dao.userInsert(user, connection);

			PointDAO pointDAO = new PointDAOImpl();
			PointDTO point = new PointDTO(0, user.getUserId(), null, "가입", +5000);

			rowNum += pointDAO.pointInsert(point, connection);

			state = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
			
				if (state) {
					connection.commit();
				} else {
					connection.rollback();
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public ArrayList<MemberDTO> userList() {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		ArrayList<MemberDTO> dtos = null;

		try {
			connection = DBUtil.getConnect();
			dtos = dao.userList(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return dtos;
	}

	@Override
	public MemberDTO userSelect(String userId) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		MemberDTO dto = null;

		try {
			connection = DBUtil.getConnect();
			dto = dao.userSelect(userId, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return dto;
	}

	@Override
	public MemberDTO userLogin(String userId, String userPw) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		MemberDTO dto = null;

		try {
			connection = DBUtil.getConnect();
			dto = dao.userLogin(userId, userPw, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return dto;
	}

	@Override
	public int userDelete(String userId) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();
			rowNum = dao.userDelete(userId, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public int userUpdateType(String userId, String userType) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();
			dao.userUpdateType(userId, userType, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public int userUpdateLoginTime(String userId) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();
			rowNum = dao.userUpdateLoginTime(userId, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public boolean idCheck(String userId) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		boolean check = false;

		try {
			connection = DBUtil.getConnect();
			check = dao.idCheck(userId, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return check;
	}

	@Override
	public int userUpdate(MemberDTO user) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();
			rowNum = dao.userUpdate(user, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}

}
