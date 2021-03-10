package com.thisisthat.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.usermanagement.vo.userVO;
import com.thisisthat.user.register.vo.TestVO;

@Controller
public class AdminController {

	@RequestMapping("/main.mdo")
	public String mainView() {
		return "/admin/main";
	}

	@RequestMapping("/login.mdo")
	public String loginView() {
		return "/admin/login";
	}

	@GetMapping("articleList.mdo")
	public String notice(Model model,@RequestParam(value="where")String where) {
		List<TestVO> voList = new ArrayList<TestVO>();
		for(int i = 1; i<=10; i++) {
			TestVO vo = new TestVO();
			vo.setCnt(new Long(i));
			vo.setRegDate(new Date());
			vo.setSeq(new Long(i));
			vo.setTitle(i+"제목");
			vo.setWriter(i+"작성자");
			voList.add(vo);
		}
		model.addAttribute("articleList",voList);
		model.addAttribute("where", where);
		return "/admin/articleList";
	}
	
	@GetMapping("articleGate.mdo")
	public String articleGate(@RequestParam(value="where")String where) {
		return "redirect:articleList.mdo?where="+where;
	}
	
	@GetMapping("insertArticle.mdo")
	public String insertArticle() {
		return "/admin/insertArticle";
	}
	
	
	
	
}
