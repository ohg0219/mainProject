package com.thisisthat.admin.usermanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.usermanagement.service.UserManagementService;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Controller
public class UserManagementController {

	@Autowired
	private UserManagementService userService;


	@GetMapping("userList.mdo")
	public String getUserList(Model model, UserVO vo) {
		List<UserVO> getUserList = userService.getUserList(vo);		
		List<UserVO> userList = new ArrayList<UserVO>();
		for(UserVO userTemp : getUserList) {
			StringBuffer temp = new StringBuffer();
			System.out.println(userTemp.toString());
			if(userTemp.getUserPhone() !=null) {
				temp.append(userTemp.getUserPhone().substring(0, 3));
				temp.append("-****-");
				temp.append(userTemp.getUserPhone().substring(userTemp.getUserPhone().length()-4, userTemp.getUserPhone().length()));
				userTemp.setUserPhone(temp.toString());
			}
			temp = new StringBuffer();
			if(userTemp.getUserName().length()==2) {
				temp.append(userTemp.getUserName().substring(0, 1)+"*");
				userTemp.setUserName(temp.toString());
			}else if(userTemp.getUserName().length()>2){
				temp.append(userTemp.getUserName().substring(0,1));
				for(int i =0; i<userTemp.getUserName().length()-2;i++) {
					temp.append("*");
				}
				temp.append(userTemp.getUserName().substring(userTemp.getUserName().length()-1,userTemp.getUserName().length()));
				userTemp.setUserName(temp.toString());
			}	
			userList.add(userTemp);
		}
		model.addAttribute("userInfo", getUserList);
		return "/admin/userList";
	}

	@RequestMapping("/getUser.mdo")
	public String getUser(Model model, @RequestParam(value="userId") String id) {
		UserVO uservo = userService.UserManagement(id);
		if(uservo.getUserPhone() !=null) {
			StringBuffer temp = new StringBuffer();
			temp.append(uservo.getUserPhone().substring(0, 3));
			temp.append("-");
			temp.append(uservo.getUserPhone().substring(3, 7));
			temp.append("-");
			temp.append(uservo.getUserPhone().substring(7, 11));
			/*
			String 공일공 = uservo.getUserPhone().substring(0,3);
			temp.append(공일공);
			String 중간 = uservo.getUserPhone().substring(3,7);
			temp.append(중간);
			String 끝 = uservo.getUserPhone().substring(7,11);
			temp.append(끝);
			 */
			uservo.setUserPhone(temp.toString());
		}
		model.addAttribute("user", uservo);
		return "/admin/getUser";
	}

	
	
	
	
	
	


}
