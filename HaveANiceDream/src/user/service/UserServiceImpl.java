package user.service;

import java.util.ArrayList;

import user.MemberDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;

public class UserServiceImpl implements UserService {

	@Override
	public int userInsert(MemberDTO user) {
		UserDAO dao = new UserDAOImpl();
		int rowNum = dao.userInsert(user);
		
		return rowNum;
	}

	@Override
	public ArrayList<MemberDTO> userList() {
		UserDAO dao = new UserDAOImpl();
		ArrayList<MemberDTO> dtos = dao.userList();
		
		return dtos;
	}

	@Override
	public MemberDTO userSelect(String userId) {
		UserDAO dao = new UserDAOImpl();
		MemberDTO dto = dao.userSelect(userId);
		
		return dto;
	}

	@Override
	public MemberDTO userLogin(String userId, String userPw) {
		UserDAO dao = new UserDAOImpl();
		MemberDTO dto = dao.userLogin(userId, userPw);
		
		return dto;
	}

}
