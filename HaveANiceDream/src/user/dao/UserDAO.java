package user.dao;

import java.util.ArrayList;

import user.MemberDTO;

public interface UserDAO {
	int userInsert(MemberDTO user);
	ArrayList<MemberDTO> userList();
	MemberDTO userSelect(String userId);
	MemberDTO userLogin(String userId, String userPw);
}
