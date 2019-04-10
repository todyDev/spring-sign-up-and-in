package com.tody.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tody.common.exception.AlreadyExistingEmailException;
import com.tody.common.exception.AlreadyExistingIdException;
import com.tody.user.service.UserService;
import com.tody.user.util.RegisterRequest;
import com.tody.user.util.RegisterRequestValidator;

@Controller
@RequestMapping(value="/signup")
public class SignupController {
	
	@Resource(name="userService")
	private UserService userSer;
	
	@RequestMapping(value="/step1")
	public String step1() throws Exception {
		return "user/signup/step1";
	}
	
	@RequestMapping(value="/step2", method=RequestMethod.POST)
	public ModelAndView step2(@RequestParam(value="agree", defaultValue="false") Boolean agree) throws Exception {

		ModelAndView mv = new ModelAndView();
		
		if(!agree) {
			mv.setViewName("/user/signup/step1");
			return mv;
		}
		
		mv.setViewName("/user/signup/step2");
		mv.addObject("registerRequest", new RegisterRequest());
		return mv;
		
	}
	
    @RequestMapping(value="/step3", method=RequestMethod.POST)
    public ModelAndView step3(RegisterRequest regReq, Errors errors) throws Exception{
    	
        new RegisterRequestValidator().validate(regReq, errors);
        ModelAndView mv = new ModelAndView();
        
        if(errors.hasErrors()) {
        	mv.setViewName("/user/signup/step2");
            return mv;
        }
        
        try {
            userSer.register(regReq);
            
        } catch (AlreadyExistingEmailException e) {
            errors.rejectValue("email", "duplicate", "이미 가입된 이메일입니다.");
            mv.setViewName("/user/signup/step2");
            return mv;
            
        } catch (AlreadyExistingIdException e) {
            errors.rejectValue("id", "duplicate", "이미 가입된 아이디입니다.");
            mv.setViewName("/user/signup/step2");
            return mv;
        }
        
        mv.setViewName("/user/signup/step3");
        return mv;
    }

}
