package com.thisisthat.admin.usermanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.thisisthat.admin.usermanagement.service.UserManagementService;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Controller
@RequestMapping("/admin")
public class UserManagementController {

	@Autowired
	private UserManagementService userService;


	@GetMapping("/userList.mdo")
	public String getUserList(Model model, UserVO vo) {
		List<UserVO> getUserList = userService.getUserList(vo);		
		List<UserVO> userList = new ArrayList<UserVO>();
		for(UserVO userTemp : getUserList) {
			StringBuffer temp = new StringBuffer();
			if(userTemp.getUserPhone() !=null) {
				temp.append(userTemp.getUserPhone().substring(0, 3));
				temp.append("-****-");
				temp.append(userTemp.getUserPhone().substring(userTemp.getUserPhone().length()-6, userTemp.getUserPhone().length()-2));
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
		model.addAttribute("userInfo", userList);
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
			uservo.setUserPhone(temp.toString());
		}
		model.addAttribute("user", uservo);
		return "/admin/getUser";
	}

	@PostMapping("/pwCheck.mdo")
	public String pwCheck(@RequestParam("userId")String userId,
						  @RequestParam("userPw")String userPw, HttpSession session,
						  RedirectAttributes model) {
		System.out.println(userId);
		System.out.println(userPw);
		UserVO sessionUser = (UserVO)session.getAttribute("userId");
		if(BCrypt.checkpw(userPw, sessionUser.getUserPw())) {
			return "redirect:/admin/getUser.mdo?userId="+userId;
		}else {
			model.addFlashAttribute("msg","fail");
			model.addFlashAttribute("failId",userId);
			return "redirect:/admin/userList.mdo";
		}

		
	}
	
	
	
	
	


}
