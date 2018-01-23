package user.service;

import java.util.ArrayList;

import user.dto.MemberDTO;

public interface UserService {
	int userInsert(MemberDTO user);

	ArrayList<MemberDTO> userList();

	MemberDTO userSelect(String userId);

	MemberDTO userLogin(String userId, String userPw);

	int userDelete(String userId);

	int userUpdateType(String userId, String userType);

	int userUpdateLoginTime(String userId);

	boolean idCheck(String userId);
}
