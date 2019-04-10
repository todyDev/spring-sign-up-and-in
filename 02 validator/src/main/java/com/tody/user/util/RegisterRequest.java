package com.tody.user.util;

public class RegisterRequest {

    private String id;
    private String email;
    private String name;
    private String password;
    private String checkPassword;
    
    //비밀번호 확인
    public boolean isPwEqualToCheckPw() {
        return password.equals(checkPassword);
    }

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheckPassword() {
		return checkPassword;
	}
	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

}
