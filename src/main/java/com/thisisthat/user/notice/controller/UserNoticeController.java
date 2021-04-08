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
import com.thisisthat.util.PagingVO;

@Controller
public class UserNoticeController {
	@Autowired
	UserNoticeService userNoticeService;
	
	//공지사항 페이지
	@GetMapping("/notice.do")
	public String noticeList(UserNoticeVO vo,
			Model model,
			@RequestParam(value = "keyword", required = false, defaultValue = "")String keyword,
			@RequestParam(value = "searchOption" ,required = false, defaultValue = "all")String searchOption,
			@RequestParam(value = "nowPage", required = false)Integer nowPage) {
		if(nowPage == null) nowPage = 1; //처음들어오면 1페이지 
		System.out.println(keyword);
		System.out.println(searchOption);
		PagingVO paging = new PagingVO(userNoticeService.noticeCount(searchOption, keyword),nowPage,15);
		List<UserNoticeVO> noticeList = userNoticeService.noticeList(paging, searchOption, keyword);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchOption",searchOption);
		model.addAttribute("paging", paging);
		return "/user/notice";
	}

	//이벤트 페이지
	@GetMapping("/event.do")
	public String eventList(UserNoticeVO vo,
			Model model,
			@RequestParam(value = "keyword", required = false, defaultValue = "")String keyword,
			@RequestParam(value = "searchOption" ,required = false, defaultValue = "all")String searchOption,
			@RequestParam(value = "nowPage", required = false)Integer nowPage) {
		if(nowPage == null) nowPage = 1;
		System.out.println(keyword);
		System.out.println(searchOption);
		PagingVO paging = new PagingVO(userNoticeService.noticeCount(searchOption, keyword),nowPage,15);
		List<UserNoticeVO> eventList = userNoticeService.eventList(paging, searchOption, keyword);
		model.addAttribute("eventList", eventList);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchOption",searchOption);
		model.addAttribute("paging", paging);
		return "/user/event";
	}
	
	//공지사항 글 상세보기
	@GetMapping("/noticeView.do")
	public String getNotice(@RequestParam("board_no") int board_no, UserNoticeVO vo, Model model) {
		//조회수 높이기
		userNoticeService.plusCnt(board_no);
		vo.setBoard_no(board_no);
		//끝
		UserNoticeVO noticeVO = userNoticeService.getNotice(vo);
		model.addAttribute("notice", noticeVO);
		return "/user/noticeView";
	}

	//이벤트 글 상세보기
	@GetMapping("/eventView.do")
	public String getEvent(@RequestParam("board_no") int board_no, UserNoticeVO vo, Model model) {
		//조회수 높이기
		userNoticeService.plusCnt(board_no);
		vo.setBoard_no(board_no);
		//끝
		UserNoticeVO noticeVO = userNoticeService.getEvent(vo);
		model.addAttribute("event", noticeVO);
		return "/user/eventView";
	}
	/*
	//공지사항 글 검색
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
	
	//이벤트글 검색 구현
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
*/
	
	
}