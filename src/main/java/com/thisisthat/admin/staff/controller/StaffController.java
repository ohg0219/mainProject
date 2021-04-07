package com.thisisthat.admin.staff.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.staff.service.StaffRegisterService;
import com.thisisthat.admin.usermanagement.vo.UserVO;
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
	
	@GetMapping("/admin/modifyStaff.mdo")
	public String modifyStaff(Model model, HttpSession session) {
		UserVO vo = (UserVO)session.getAttribute("adminId");
		if(vo.getUserPhone()!=null) {
			String phone1 = vo.getUserPhone().substring(0, 3);
			String phone2 = vo.getUserPhone().substring(3, 7);
			String phone3 = vo.getUserPhone().substring(7, 11);
			model.addAttribute("phone1", phone1);
			model.addAttribute("phone2", phone2);
			model.addAttribute("phone3", phone3);
		}
		model.addAttribute("staff", vo);
		return"/admin/staff/modifyStaff";
	}
	
	@PostMapping("/admin/modifyStaff.mdo")
	public String modifyStaff(UserVO vo, String phone1,
			String phone2, String phone3) {
		vo.setUserPhone(phone1 + phone2 + phone3);
		vo.setUserPw(BCrypt.hashpw(vo.getUserPw(), BCrypt.gensalt()));
		staffRegisterService.modifyStaff(vo);
		return "redirect:/admin/main.mdo";
	}
	
	
}
