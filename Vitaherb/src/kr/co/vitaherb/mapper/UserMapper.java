package kr.co.vitaherb.mapper;

import kr.co.vitaherb.domain.User;

public interface UserMapper {
	//	User loginUser(User user);
	void insertUser(User user);

	User loginUser(String userId);
	User idCheck(String userId);
	User emailCheck(String userEmail);

	User findUser(String email);
}



