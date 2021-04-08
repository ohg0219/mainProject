package com.thisisthat.admin.main.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.main.service.AdminService;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Controller

public class AdminController {
	
	@Autowired
	AdminService dao;
	
	
	@RequestMapping("/admin/404.mdo")
	public String test() {
		return "/admin/404";
	}
	
	@RequestMapping("/admin/main.mdo")
	public String mainView(Model model) {
		DecimalFormat df = new DecimalFormat("###,###");
		model.addAttribute("thisMonthSales",df.format(dao.getThisMonthSales()));
		model.addAttribute("thisDaySales",df.format(dao.getThisDaySales()));
		model.addAttribute("noAnswerCount",dao.noAnswerCount());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> dateListString = new ArrayList<>();
		List<Date> dateList = new ArrayList<Date>();
		for(int i = 6;i>=0;i--) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -i);
			dateListString.add(sdf.format(cal.getTime()));
			dateList.add(cal.getTime());
		}
		model.addAttribute("dateList",dateListString);
		model.addAttribute("dataList",dao.getOneWeekSales(dateList));
		model.addAttribute("todayCategorySales",dao.getTodayCatgorySales());
		return "/admin/main";
	}

	@RequestMapping("/login.mdo")
	public String loginView() {
		return "/admin/login";
	}
	@RequestMapping("/admin/logout.mdo")
	public String removeSession(HttpSession session, HttpServletResponse response) {
		Cookie cookie = new Cookie("userVO", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		session.invalidate();
		return "/admin/login";
	}

	@PostMapping("/login.mdo")
	public String loginCheck(UserVO vo, HttpSession session,Model model,
			@RequestParam(value="autoLogin",defaultValue= "false")boolean autoLogin,
			HttpServletResponse response) {
		UserVO user = dao.idCheck(vo.getUserId());
		if(user == null) {
			
		}else if(BCrypt.checkpw(vo.getUserPw(), user.getUserPw())) {
			if(user.getUserRole()<21) {
				session.setAttribute("adminId", user);
				if(autoLogin) {
					Cookie cookie = new Cookie("userVO", user.getUserId());
					cookie.setMaxAge(60*60*24*30);//한달설정
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				return "redirect:/admin/main.mdo";
			}else {
				model.addAttribute("msg","roleFail");
				return "/admin/login";
			}
		}
		
		model.addAttribute("msg","pwFail");
		return "/admin/login";
	}
	
	

	
	@GetMapping("userManagement.mdo")
	public String userManagement() {
		
		return "/admin/userManagement";
	}
}
