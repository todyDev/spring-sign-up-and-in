package com.tody.user.persistence;

import org.springframework.stereotype.Repository;

import com.tody.common.persistence.AbstractDAO;
import com.tody.user.domain.UserVO;
import com.tody.user.util.RegisterRequest;

@Repository("userDAO")
public class UserDAO extends AbstractDAO {

	public UserVO selectByEmail(String email) throws Exception {
		return (UserVO)selectOne("user.selectByEmail", email);
	}

	public UserVO selectById(String id) throws Exception {
		return (UserVO)selectOne("user.selectById", id);
	}

	public void insertUser(RegisterRequest regReq) throws Exception {
		insert("user.register", regReq);
	}
}
