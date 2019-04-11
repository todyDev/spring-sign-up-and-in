package com.tody.user.service;

import com.tody.user.util.AuthInfo;
import com.tody.user.util.LoginCommand;
import com.tody.user.util.RegisterRequest;

public interface UserService {

	void register(RegisterRequest regReq) throws Exception;

	AuthInfo loginAuth(LoginCommand loginCommand) throws Exception;

}
