package com.tody.user.service;

import com.tody.user.util.RegisterRequest;

public interface UserService {

	void register(RegisterRequest regReq) throws Exception;

}
