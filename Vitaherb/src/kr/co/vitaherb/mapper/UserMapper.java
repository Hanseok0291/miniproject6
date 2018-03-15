package kr.co.vitaherb.mapper;

import java.util.List;

import kr.co.vitaherb.domain.User;

public interface UserMapper {
	List<User> loginUser();
    void insertUser(User user);
}
