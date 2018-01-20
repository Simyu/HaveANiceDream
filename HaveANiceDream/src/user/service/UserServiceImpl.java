package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import point.PointDTO;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.dto.MemberDTO;

public class UserServiceImpl implements UserService {

	@Override
	public int userInsert(MemberDTO user) {
		Connection connection = null;
		UserDAO dao = new UserDAOImpl();
		int rowNum = 0;
		
		try {
			connection = DBUtil.getConnect();
			rowNum = dao.userInsert(user, connection);
			
			if(rowNum > 0) {
				PointDAO pointDAO = new PointDAOImpl();
				PointDTO point = new PointDTO(0, user.getUserId(), null, "가입", +5000);
				rowNum += pointDAO.pointInsert(point, connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			dto = dao.userSelect(userId,connection);
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

}
