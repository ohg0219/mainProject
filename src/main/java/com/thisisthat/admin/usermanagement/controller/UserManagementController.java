package com.thisisthat.admin.usermanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisisthat.admin.usermanagement.vo.UserVO;

@Controller
public class UserManagementController {

	@GetMapping("userList.mdo")
	public String userManagement(Model model) {
		List<UserVO> user = new ArrayList<UserVO>();
		for (int i=1; i<=10; i++) {
			UserVO vo = new UserVO();
			vo.setUserId("yejin" + i);
			vo.setUserName("예진");
			vo.setNickName(i+"nick");
			vo.setUserPhone("01030671121" );
			vo.setUserEmail("aabc@naver.com" + i);
			vo.setUserRole(10 + i);
			vo.setFirstAddress("서울특별시");
			vo.setLastAddress("종로구");
			vo.setInDate(new Date());
			vo.setOutDate(new Date());
			user.add(vo);
		}
		
		
		List<UserVO> userList = new ArrayList<UserVO>();
		for(UserVO userTemp : user) {
			StringBuffer temp = new StringBuffer();
			temp.append(userTemp.getUserPhone().substring(0, 3));
			temp.append("-****-");
			temp.append(userTemp.getUserPhone().substring(userTemp.getUserPhone().length()-4, userTemp.getUserPhone().length()));
			userTemp.setUserPhone(temp.toString());
			temp = new StringBuffer();
			if(userTemp.getUserName().length()==2) {
				temp.append(userTemp.getUserName().substring(0, 1)+"*");
				userTemp.setUserName(temp.toString());
			}else {
				temp.append(userTemp.getUserName().substring(0,1));
				for(int i =0; i<userTemp.getUserName().length()-2;i++) {
					temp.append("*");
				}
				temp.append(userTemp.getUserName().substring(userTemp.getUserName().length()-1,userTemp.getUserName().length()));
				userTemp.setUserName(temp.toString());
			}
			
			userList.add(userTemp);
		}
		model.addAttribute("userInfo", userList);
		
		return "/admin/userList";
	}
	
	
	
	@RequestMapping("UserList.mdo#")
	public String getUserList() {
		
		
		return null;
	}
	
	
	
}
