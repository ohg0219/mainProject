package com.thisisthat.admin.staff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {
	
	@GetMapping("/admin/insertStaff.mdo")
	public String insertStaff() {
		
		return "/admin/staff/insertStaff";
	}
}
