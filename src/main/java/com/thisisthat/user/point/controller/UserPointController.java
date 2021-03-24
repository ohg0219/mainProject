package com.thisisthat.user.point.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.point.service.UserPointService;
import com.thisisthat.user.point.vo.UserPointVO;

@Controller
@RequestMapping("/user/*")
public class UserPointController {
	
	@Autowired
	private UserPointService userPointService;

	@RequestMapping("userPoint.do")
	public String pointList(HttpSession session,Model model, UserPointVO userPointVO) {
		String id = null;
		if(session.getAttribute("userId") !=null) {
			id = (String) session.getAttribute("userId");
		}
		/**
		 * 사용 가능 포인트
		 */
		userPointVO.setUser_id(id);
		UserPointVO pointSum = userPointService.pointsum(userPointVO);
		
		model.addAttribute("pointSum", pointSum);

		/**
		 * 사용 포인트
		 */
		userPointVO.setUser_id(id);
		UserPointVO usingSum = userPointService.usingSum(userPointVO);
		
		model.addAttribute("usingSum", usingSum);
		
		
		/**
		 * 리스트 보기
		 */
		userPointVO.setUser_id(id);
		
		List<UserPointVO> pointList = userPointService.pointList(userPointVO);
		
		model.addAttribute("article", pointList);
		return "/user/userPoint/userPoint";
	}
	
	
}//end class
