package com.thisisthat.admin.staff.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.staff.service.StaffRegisterService;
import com.thisisthat.user.register.service.UserRegisterService;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Controller
public class StaffController {
	
	@Autowired
	StaffRegisterService staffRegisterService;
	
	@GetMapping("/admin/insertStaff.mdo")
	public String insertStaff() {
		
		return "/admin/staff/insertStaff";
	}
	
	@PostMapping("/admin/register.mdo")
	public String insertStaff(UserRegisterVO vo, Model model,
			@RequestParam("phone1")String phone1,
			@RequestParam("phone2")String phone2,
			@RequestParam("phone3")String phone3) {
		
		vo.setPassword(BCrypt.hashpw(vo.getId(), BCrypt.gensalt()));
		vo.setPhone(phone1+phone2+phone3);
		staffRegisterService.insertStaff(vo);
		return "/admin/main";
	}
	
}
