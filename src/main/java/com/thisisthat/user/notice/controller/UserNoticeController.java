package com.thisisthat.user.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.notice.vo.NoticeVO;
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
	public String getNotice(@RequestParam("board_no") int board_no, UserNoticeVO vo, Model model) {
		userNoticeService.plusCnt(board_no);
		vo.setBoard_no(board_no);
		UserNoticeVO noticeVO = userNoticeService.getNotice(vo);
		model.addAttribute("notice", noticeVO);
		return "/user/noticeView";
	}

	@GetMapping("/eventView.do")
	public String getEvent(@RequestParam("board_no") int board_no, UserNoticeVO vo, Model model) {
		userNoticeService.plusCnt(board_no);
		vo.setBoard_no(board_no);
		UserNoticeVO noticeVO = userNoticeService.getEvent(vo);
		model.addAttribute("event", noticeVO);
		return "/user/eventView";
	}
	
	@RequestMapping("/noticesearch.do")
	public String noticesearch(Model model, 
			@RequestParam("searchOption")String searchOption , 
			@RequestParam("keyword")String keyword ,
			UserNoticeVO vo) {
		if(searchOption.equals("all")) {
			vo.setKeyword(keyword);
			List<UserNoticeVO> noticeList = userNoticeService.allNotice(vo);
			model.addAttribute("noticeList", noticeList);
			return "/user/notice";
		}else if(searchOption.equals("board_title")){
			vo.setKeyword(keyword);
			List<UserNoticeVO> noticeList = userNoticeService.titleNotice(vo);
			for(UserNoticeVO sdf : noticeList) {
				System.out.println(sdf.toString());
			}
			model.addAttribute("noticeList", noticeList);
			return "/user/notice";
		}else if(searchOption.equals("board_writer")) {
			vo.setKeyword(keyword);
			List<UserNoticeVO> noticeList = userNoticeService.writerNotice(vo);
			model.addAttribute("noticeList", noticeList);
			return "/user/notice";
		}else if(searchOption.equals("board_content")) {
			vo.setKeyword(keyword);
			List<UserNoticeVO> noticeList = userNoticeService.contentNotice(vo);
			model.addAttribute("noticeList", noticeList);
			return "/user/notice";
		}
		return null;
	}
	
	@RequestMapping("/eventsearch.do")
	public String eventsearch(Model model, 
			@RequestParam("searchOption")String searchOption , 
			@RequestParam("keyword")String keyword ,
			UserNoticeVO vo) {
		if(searchOption.equals("all")) {
			vo.setKeyword(keyword);
			List<UserNoticeVO> eventList = userNoticeService.allNotice(vo);
			model.addAttribute("eventList", eventList);
			return "/user/event";
		}else if(searchOption.equals("board_title")){
			vo.setKeyword(keyword);
			List<UserNoticeVO> eventList = userNoticeService.titleNotice(vo);
			model.addAttribute("eventList", eventList);
			return "/user/event";
		}else if(searchOption.equals("board_writer")) {
			vo.setKeyword(keyword);
			List<UserNoticeVO> eventList = userNoticeService.writerNotice(vo);
			model.addAttribute("eventList", eventList);
			return "/user/event";
		}else if(searchOption.equals("board_content")) {
			vo.setKeyword(keyword);
			List<UserNoticeVO> eventList = userNoticeService.contentNotice(vo);
			model.addAttribute("eventList", eventList);
			return "/user/event";
		}
		return null;
	}

	
	
}