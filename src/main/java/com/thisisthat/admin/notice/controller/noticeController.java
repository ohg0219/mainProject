package com.thisisthat.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.notice.service.NoticeService;
import com.thisisthat.admin.notice.vo.NoticeVO;

@Controller
public class noticeController {

	@Autowired
	private NoticeService noticeService;
	private NoticeVO noticeVO;
	

	@PostMapping("insertArticle.mdo")
	public String insertNotice(NoticeVO noticeVO)throws IOException{
		noticeService.insertNotice(noticeVO);
		return "redirect:articleList.mdo?where=notice";
	}
	
	@GetMapping("articleList.mdo")
	public String notice(Model model,@RequestParam(value="where")String where) {
		List<NoticeVO> noticeList = noticeService.articleList();

		model.addAttribute("articleList",noticeList);
		model.addAttribute("where", where);
		return "/admin/articleList";
	}

}
