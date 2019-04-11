package com.tody.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tody.common.exception.AlreadyExistingEmailException;
import com.tody.common.exception.AlreadyExistingIdException;
import com.tody.user.domain.UserVO;
import com.tody.user.persistence.UserDAO;
import com.tody.user.util.RegisterRequest;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Override
	public void register(RegisterRequest regReq) throws Exception {
		
        UserVO email = userDAO.selectByEmail(regReq.getEmail());
        if(email!=null) {
            throw new AlreadyExistingEmailException(regReq.getEmail()+" is duplicate email.");
        }
        
        UserVO id = userDAO.selectById(regReq.getId());
        if(id!=null) {
            throw new AlreadyExistingIdException(regReq.getId()+" is duplicate id.");
        }
        
        userDAO.insertUser(regReq);
	}

}
