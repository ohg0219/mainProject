package com.thisisthat.admin.notice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.thisisthat.admin.notice.service.NoticeService;
import com.thisisthat.admin.notice.vo.NoticeVO;

@Controller
public class noticeController {

	@Autowired
	private NoticeService noticeService;
	
	
//	@PostMapping("/notice.mdo")
//	public String insertNotice(NoticeVO noticeVO)throws IOException{
//		noticeService.insertNotice(noticeVO);
//		return "/admin/articleList";
//	}
	@PostMapping("insertArticle.mdo")
	public String insertNotice(NoticeVO noticeVO)throws IOException{
		noticeService.insertNotice(noticeVO);
		return "redirect:articleList.mdo?where=notice";
	}
}
