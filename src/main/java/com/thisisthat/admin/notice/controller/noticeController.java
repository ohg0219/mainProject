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
	

	@PostMapping("insertArticle.mdo")
	public String insertNotice(NoticeVO noticeVO,@RequestParam("board_group")String board_group)throws IOException{
		noticeService.insertNotice(noticeVO);
		return "redirect:articleList.mdo?where="+board_group;
	}
	
	@GetMapping("insertArticle.mdo")
	public String insertArticle() {
		return "/admin/insertArticle";
	}
	
	@GetMapping("noticeGate.mdo")
	public String noticeGate(@RequestParam(value="board_no")String board_no) {
		return "redirect:article.mdo?board_no="+board_no;
	}
	
	
	@GetMapping("article.mdo")
	public String getNotice(Model model,@RequestParam(value="board_no")Long board_no,NoticeVO noticeVO) {
		NoticeVO article  = noticeService.notice(noticeVO);
		
		model.addAttribute("article", article);
		model.addAttribute("board_no", board_no);
		return "/admin/article";			
	}
	
	@GetMapping("updateGate.mdo")
	public String updateGate(@RequestParam(value="board_no")String board_no) {
		return "redirect:updateArticle.mdo?board_no="+board_no;
	}
	
	@GetMapping("updateArticle.mdo")
	public String updateArticle(Model model,@RequestParam(value="board_no")Long board_no,NoticeVO noticeVO) {
		NoticeVO article  = noticeService.notice(noticeVO);
		
		model.addAttribute("article", article);
		model.addAttribute("board_no", board_no);
		return "/admin/updateArticle";
				
	}
	
	@GetMapping("articleList.mdo")
	public String getNoticeList(Model model,@RequestParam(value="where")String where) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoard_group(where);
		List<NoticeVO> noticeList = noticeService.noticeList(noticeVO);
		
		model.addAttribute("articleList",noticeList);
		model.addAttribute("where", where);
		return "/admin/articleList";
	}
	
	@GetMapping("articleGate.mdo")
	public String articleGate(@RequestParam(value="where")String where) {
		
		return "redirect:articleList.mdo?where="+where;
	}
	
	
	

}
