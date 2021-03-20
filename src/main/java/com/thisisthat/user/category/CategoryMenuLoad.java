package com.thisisthat.user.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class CategoryMenuLoad implements HandlerInterceptor {

	@Autowired
	private CategoryMenuService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session =  request.getSession();
		session.setAttribute("menu", service.getCategoryList());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
