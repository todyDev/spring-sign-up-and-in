package com.tody.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	
	protected Logger log = Logger.getLogger(getClass());

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("===================        END        ===================\n");
        }
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("===================       START       ===================");
            log.debug(" Request URI \t:  " + request.getRequestURI());
        }
        return super.preHandle(request, response, handler);
	}

}
