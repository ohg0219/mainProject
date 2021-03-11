package com.thisisthat.admin.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.thisisthat.admin.usermanagement.vo.UserVO;

public class AdminSecurity extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj)
			throws Exception {
		HttpSession session = req.getSession();
		UserVO vo = (UserVO)session.getAttribute("userId");
		if(vo == null) {
			res.sendRedirect("/login.mdo");
			return false;
		}else if(vo.getUserRole()  > 21) {
			res.sendRedirect("/main.do");
			return false;
		}
		return true;
	}

}
