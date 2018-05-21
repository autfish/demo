package com.autfish.demo.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorityInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String backUrl = request.getServletPath();
		String sessionName = "adminUser";
		System.out.println(request.getSession(true).getAttribute(sessionName));
		if (request.getSession(true).getAttribute(sessionName) == null) {
			response.sendRedirect(request.getContextPath() + "/login?backUrl=" + backUrl);
			return false;
		}
		
		return true;
	}
}
