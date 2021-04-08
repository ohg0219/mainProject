package com.thisisthat.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.Parameter;
import com.thisisthat.admin.notice.protocol.BoardTypeProtocol;
import com.thisisthat.admin.notice.service.NoticeService;
import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.notice.vo.SearchVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin/*")
public class noticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("deleteGate.mdo")
	public String deleteGate(NoticeVO noticeVO, @RequestParam("board_no") Long board_no,
			@RequestParam("board_group") String board_group) {

		if (board_group.equals("notice")) {
			noticeService.deleteNotice(noticeVO);
			return "redirect:getArticleList.mdo?where=notice";
		} else if (board_group.equals("event")) {
			noticeService.deleteNotice(noticeVO);
			return "redirect:getArticleList.mdo?where=event";

		}
		return null;
	}

	@RequestMapping("updateNotice.mdo")
	public String updateNotice(NoticeVO noticeVO, @RequestParam("board_no") Long board_no,
			@RequestParam("board_title") String board_title, @RequestParam("board_content") String board_content,
			@RequestParam("board_group") String board_group) throws IOException {
		if (board_group.equals("notice")) {
			noticeService.updateNotice(noticeVO);
			return "redirect:getArticleList.mdo?where=notice";
		} else if (board_group.equals("event")) {
			noticeService.updateNotice(noticeVO);
			return "redirect:getArticleList.mdo?where=event";
		}
		return null;
	}

	@RequestMapping("insertNotice.mdo")
	public String insertNotice(HttpSession session, UserVO userVO, NoticeVO noticeVO,
			@RequestParam("board_group") String board_group) throws IOException {
		String id = null;
		UserVO getUser = null;
		if (session.getAttribute("adminId") != null) {

			getUser = (UserVO) session.getAttribute("adminId");
			id = getUser.getNickName();
		}

		noticeVO.setBoard_writer(id);
		noticeService.insertNotice(noticeVO);
		return "redirect:getArticleList.mdo?where=" + board_group;
	}

	@RequestMapping("insertArticle.mdo")
	public String insertArticle() {
		return "/admin/insertArticle";
	}

	@RequestMapping("noticeGate.mdo")
	public String noticeGate(@RequestParam(value = "board_no") Long board_no) {
		return "redirect:article.mdo?board_no=" + board_no;
	}

	@GetMapping("article.mdo")
	public String getNotice(Model model, @RequestParam(value = "board_no") Long board_no, NoticeVO noticeVO) {
		NoticeVO article = noticeService.notice(noticeVO);

		model.addAttribute("article", article);
		model.addAttribute("board_no", board_no);
		return "/admin/article";
	}

	@RequestMapping("updateGate.mdo")
	public String updateGate(@RequestParam(value = "board_no") Long board_no) {
		return "redirect:updateArticle.mdo?board_no=" + board_no;
	}

	@RequestMapping("updateArticle.mdo")
	public String updateArticle(Model model, @RequestParam(value = "board_no") Long board_no, NoticeVO noticeVO) {
		NoticeVO article = noticeService.notice(noticeVO);

		model.addAttribute("article", article);
		model.addAttribute("board_no", board_no);
		return "/admin/updateArticle";

	}

	@RequestMapping("articleGate.mdo")
	public String articleGate(@RequestParam(value = "where") String where) {

		return "redirect:getArticleList.mdo?where=" + where;
	}

	@RequestMapping("getArticleList.mdo")
	public String getNoticeList(Model model, @RequestParam(value = "where") String where, PagingVO vo,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "searchOption", required = false) String searchOption,
			@RequestParam(value = "keyword", required = false) String keyword) {
	
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoard_group(where);
		SearchVO search;
		
		if(searchOption == null) {
			searchOption = "all";
		}
		
		if(nowPage == null && cntPerPage == null) {
			nowPage="1";
			cntPerPage = "15";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "15";
		}
		
		if(keyword == null) {
			search = new SearchVO(BoardTypeProtocol.filter(searchOption),keyword);
		}else {
			search = new SearchVO(BoardTypeProtocol.filter(searchOption),keyword);
		}
		
		int total = noticeService.totalCount(search, noticeVO);
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		vo.setType(BoardTypeProtocol.filter(searchOption));
		
		List<NoticeVO> noticeList = noticeService.noticeList(vo, search, noticeVO);

		model.addAttribute("total", total);
		model.addAttribute("paging", vo);
		model.addAttribute("search", search);
		model.addAttribute("articleList", noticeList);
		model.addAttribute("where", where);
		return "/admin/articleList";
	}

}// end class
