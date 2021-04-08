package com.thisisthat.user.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.thisisthat.admin.main.service.AdminService;
import com.thisisthat.admin.usermanagement.vo.UserVO;

public class UserSecurity extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj)
			throws Exception {
		HttpSession session = req.getSession();
		if(session.getAttribute("userId") == null) {
			res.sendRedirect("/login.do");
			return false;
		}else {
			return true;
		}


	}
}
