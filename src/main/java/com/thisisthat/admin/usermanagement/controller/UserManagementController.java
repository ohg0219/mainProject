package com.thisisthat.admin.usermanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thisisthat.admin.usermanagement.vo.userVO;

@Controller
public class UserManagementController {

	@GetMapping("userList.mdo")
	public String userManagement(Model model) {
		List<userVO> user = new ArrayList<userVO>();
		for (int i=1; i<=10; i++) {
			userVO vo = new userVO();
			vo.setUserId("yejin" + i);
			vo.setUserName("예진" + i);
			vo.setUserPhone("01030671121" + i);
			vo.setUserEmail("aabc@naver.com" + i);
			vo.setUserRole(10 + i);
			vo.setFirstAddress("서울특별시");
			vo.setLastAddress("종로구");
			vo.setInDate(new Date());
			vo.setOutDate(new Date());
			user.add(vo);
		}
		model.addAttribute("userInfo", user);
		return "/admin/userList";
	}
	
	
	
	
}
