package com.thisisthat.admin.role.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.role.service.RoleService;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/userRoleList.mdo")
	public String userRoleList(Model model,
			@RequestParam(value="msg", required = false)String msg,
			@RequestParam(value="nowPage", required = false)String nowPage,
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="parameter", required = false)String parameter,
			HttpSession session) {
		UserVO admin = (UserVO)session.getAttribute("adminId");
		if(admin.getUserRole()>5) {
			return "redirect:/admin/main.mdo";
		}
		if(nowPage == null) nowPage = "1";
		if(searchType == null) searchType = "all";
		if(parameter == null) parameter = "";		
		SearchVO search = new SearchVO("", searchType, parameter);
		PagingVO paging = new PagingVO(roleService.getTotal(search), Integer.parseInt(nowPage), 10);
		
		if(msg != null) model.addAttribute("msg","msg");
		model.addAttribute("userList",roleService.getUserList(search, paging));
		model.addAttribute("paging",paging);
		model.addAttribute("search",search);
		return "/admin/role/userRoleList";
	}
	
	@GetMapping("/updateRole.mdo")
	public String updateRole(@RequestParam(value="role", required = false)String userRole,
			@RequestParam(value="id", required = false)String userId,
			@RequestParam(value="nowPage", required = false)String nowPage,
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="parameter", required = false)String parameter,
			HttpSession session) {
		UserVO admin = (UserVO)session.getAttribute("adminId");
		if(admin.getUserRole()>5) {
			return "redirect:/admin/main.mdo";
		}
		UserVO user = new UserVO();
		user.setUserRole(Integer.parseInt(userRole));
		user.setUserId(userId);
		
		roleService.updateRole(user);
		
		return "redirect:/admin/userRoleList.mdo?nowPage="+nowPage+"&parameter="+parameter+"&searchType="+searchType+"&msg=msg";
	}
	
}
