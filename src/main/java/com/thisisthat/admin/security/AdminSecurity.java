package com.thisisthat.admin.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.thisisthat.admin.service.AdminService;
import com.thisisthat.admin.usermanagement.vo.UserVO;

public class AdminSecurity extends HandlerInterceptorAdapter {
	@Autowired
	AdminService dao;
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj)
			throws Exception {
		HttpSession session = req.getSession();
		UserVO vo = (UserVO)session.getAttribute("userId");
		session.setMaxInactiveInterval(60*60*2);//2시간 동안 세션유지

		if(vo == null) {
			if(req.getCookies() !=null) {
				for(Cookie cookie : req.getCookies()) {
					if(cookie.getName().equals("userVO")) {
						session.setAttribute("userId", dao.idCheck(cookie.getValue()));
						return true;
					}
				}
			}
			res.sendRedirect("/login.mdo");
			return false;
		}else if(vo.getUserRole()  > 21) {
			res.sendRedirect("/main.do");
			return false;
		}
		return true;
	}

}
