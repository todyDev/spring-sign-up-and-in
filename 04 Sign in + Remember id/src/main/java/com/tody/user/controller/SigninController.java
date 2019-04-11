package com.tody.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tody.common.exception.IdPasswordNotMatchingException;
import com.tody.user.service.UserService;
import com.tody.user.util.AuthInfo;
import com.tody.user.util.LoginCommand;

@Controller
public class SigninController {
	
	@Resource(name="userService")
	private UserService userSer;

	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public ModelAndView signinGET(LoginCommand loginCommand,
			@CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		if(rememberCookie != null) {
			loginCommand.setId(rememberCookie.getValue());
			loginCommand.setRememberId(true);
		}
		
		mv.setViewName("/user/loginForm");
		return mv;
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public ModelAndView signinPOST(@Valid LoginCommand loginCommand, BindingResult bindingResult,
			HttpSession session, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("/user/loginForm");
			return mv;
		}
		
		try {
			AuthInfo authInfo = userSer.loginAuth(loginCommand);
			session.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
			rememberCookie.setPath("/");
			
			if(loginCommand.isRememberId()) {
                rememberCookie.setMaxAge(60*60*24*7);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);
			
		} catch(IdPasswordNotMatchingException e) {
			bindingResult.rejectValue("password", "notMatch", "아이디와 비밀번호가 맞지않습니다.");
			mv.setViewName("/user/loginForm");
			return mv;
			
		}
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value="/signout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
	
}
