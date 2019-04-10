package com.tody.user.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class RegisterRequest {

	@Column
	@Pattern(regexp="\\w{4,8}", message="아이디를 4~8자로 입력해주세요.")
    private String id;
	
	@Column
	@NotEmpty(message="이메일을 입력해주세요.")
	@Email(message="이메일 형식에 맞춰 올바르게 입력해주세요.")
    private String email;
	
	@Column
	@Pattern(regexp="\\S{2,8}", message="이름을 공백없이 2~6자로 입력해주세요.")
    private String name;
	
	@Column
	@Size(min=4, max=12, message="비밀번호를 4~12자로 입력해주세요.")
    private String password;
	
	@Column
	@Size(min=4, max=12, message="비밀번호를 4~12자로 입력해주세요.")
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
