package com.tody.user.util;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class LoginCommand {
	
    @NotEmpty(message="아이디를 입력해주세요.")
    private String id;
 
    @NotEmpty(message="비밀번호를 입력해주세요.")
    private String password;
    
    private boolean rememberId;
    
    public boolean isRememberId() {
		return rememberId;
	}
	public void setRememberId(boolean rememberId) {
		this.rememberId = rememberId;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
