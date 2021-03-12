package com.thisisthat.user.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.notice.service.UserNoticeService;
import com.thisisthat.user.notice.vo.UserNoticeVO;

@Controller
public class UserNoticeController {
	@Autowired
	UserNoticeService userNoticeService;

	@GetMapping("/notice.do")
	public String noticePage(UserNoticeVO vo, Model model) {
		List<UserNoticeVO> getNoticeList = userNoticeService.getNoticeList(vo);
		model.addAttribute("noticeList", getNoticeList);
		return "/user/notice";
	}

	@GetMapping("/event.do")
	public String eventPage(UserNoticeVO vo, Model model) {
		List<UserNoticeVO> getEventList = userNoticeService.getEventList(vo);
		model.addAttribute("eventList", getEventList);
		return "/user/event";
	}

	@GetMapping("/noticeView.do")
	public String getNotice(@RequestParam("board_no") int boardNo, UserNoticeVO vo, Model model) {
		
		userNoticeService.plusCnt(boardNo);
		
		vo.setBoard_no(boardNo);
		UserNoticeVO noticeVO = userNoticeService.getNotice(vo);
		model.addAttribute("notice", noticeVO);
		return "/user/noticeView";
	}

	@GetMapping("/eventView.do")
	public String getEvent(@RequestParam("board_no") int boardNo, UserNoticeVO vo, Model model) {
		userNoticeService.plusCnt(boardNo);
		vo.setBoard_no(boardNo);
		UserNoticeVO noticeVO = userNoticeService.getEvent(vo);
		model.addAttribute("event", noticeVO);
		return "/user/eventView";
	}
}