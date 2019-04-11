package com.tody.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tody.common.exception.AlreadyExistingEmailException;
import com.tody.common.exception.AlreadyExistingIdException;
import com.tody.common.exception.IdPasswordNotMatchingException;
import com.tody.user.domain.UserVO;
import com.tody.user.persistence.UserDAO;
import com.tody.user.util.AuthInfo;
import com.tody.user.util.LoginCommand;
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

	@Override
	public AuthInfo loginAuth(LoginCommand loginCommand) throws Exception {
		
		UserVO user = userDAO.selectById(loginCommand.getId());
        if(user == null) {
            throw new IdPasswordNotMatchingException();
        }
        
        if(!user.matchPassword(loginCommand.getPassword())) {
            throw new IdPasswordNotMatchingException();
        }
        
        return new AuthInfo(user.getID(), user.getNAME(), user.getGRADE());
	}

}
