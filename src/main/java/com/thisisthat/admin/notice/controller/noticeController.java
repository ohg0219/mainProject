package com.thisisthat.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.notice.service.NoticeService;
import com.thisisthat.admin.notice.vo.NoticeVO;

@Controller
public class noticeController {

	@Autowired
	private NoticeService noticeService;



	@GetMapping("deleteGate.mdo")
	public String deleteGate(NoticeVO noticeVO,@RequestParam("board_no")Long board_no,@RequestParam("board_group")String board_group) {

		if(board_group.equals("notice")) {
			noticeService.deleteNotice(noticeVO);
			return "redirect:articleList.mdo?where=notice";
		}else if(board_group.equals("event")) {
			noticeService.deleteNotice(noticeVO);
			return "redirect:articleList.mdo?where=event";

		}
		return null;
	}

	@PostMapping("updateNotice.mdo")
	public String updateNotice(NoticeVO noticeVO,@RequestParam("board_no")Long board_no,@RequestParam("board_title")String board_title,@RequestParam("board_content")String board_content,@RequestParam("board_group")String board_group)throws IOException{
		if(board_group.equals("notice")) {
			noticeService.updateNotice(noticeVO);
			return "redirect:articleList.mdo?where=notice";
		}else if(board_group.equals("event")) {
			noticeService.updateNotice(noticeVO);
			return "redirect:articleList.mdo?where=event";
		}
		return null;
	}

	@RequestMapping("insertArticle.mdo")
	public String insertNotice(NoticeVO noticeVO,@RequestParam("board_group")String board_group)throws IOException{
		noticeService.insertNotice(noticeVO);
		return "redirect:articleList.mdo?where="+board_group;
	}

	@GetMapping("insertArticle.mdo")
	public String insertArticle() {
		return "/admin/insertArticle";
	}

	@GetMapping("noticeGate.mdo")
	public String noticeGate(@RequestParam(value="board_no")Long board_no) {
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
	public String updateGate(@RequestParam(value="board_no")Long board_no) {
		return "redirect:updateArticle.mdo?board_no="+board_no;
	}

	@GetMapping("updateArticle.mdo")
	public String updateArticle(Model model,@RequestParam(value="board_no")Long board_no,NoticeVO noticeVO) {
		NoticeVO article  = noticeService.notice(noticeVO);

		model.addAttribute("article", article);
		model.addAttribute("board_no", board_no);
		return "/admin/updateArticle";

	}

	@GetMapping("articleGate.mdo")
	public String articleGate(@RequestParam(value="where")String where) {

		return "redirect:getArticleList.mdo?where="+where;
	}

	@GetMapping("getArticleList.mdo")
	public String getNoticeList(Model model,@RequestParam(value="where")String where) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoard_group(where);
		List<NoticeVO> noticeList = noticeService.noticeList(noticeVO);


		model.addAttribute("articleList",noticeList);
		model.addAttribute("where", where);
		return "/admin/articleList";
	}

	@RequestMapping("noticesearch.mdo")
	public String noticeList(Model model, @RequestParam(value="board_group")String board_group, @RequestParam(value="searchOption")String searchOption,@RequestParam(value="keyword")String keyword, NoticeVO noticeVO) {
		if(board_group.equals("notice")) {
			if(searchOption.equals("all")) {
				noticeVO.setKeyword(keyword);
				noticeVO.setBoard_group(board_group);
				List<NoticeVO> noticeList = noticeService.allNotice(noticeVO);
				
				model.addAttribute("articleList",noticeList);
				model.addAttribute("where", board_group);
				return "/admin/articleList";
			}else if(searchOption.equals("board_title")) {
				noticeVO.setKeyword(keyword);
				noticeVO.setBoard_group(board_group);
				List<NoticeVO> noticeList = noticeService.titleNotice(noticeVO);
				
				model.addAttribute("articleList",noticeList);
				model.addAttribute("where", board_group);
				return "/admin/articleList";
			}else if(searchOption.equals("board_writer")) {
				noticeVO.setKeyword(keyword);
				noticeVO.setBoard_group(board_group);
				List<NoticeVO> noticeList = noticeService.writerNotice(noticeVO);
				
				model.addAttribute("articleList",noticeList);
				model.addAttribute("where", board_group);
				return "/admin/articleList";
			}else if(searchOption.equals("board_content")) {
				noticeVO.setKeyword(keyword);
				noticeVO.setBoard_group(board_group);
				List<NoticeVO> noticeList =	noticeService.contentNotice(noticeVO);
				
				model.addAttribute("articleList",noticeList);
				model.addAttribute("where", board_group);
				return "/admin/articleList";
			}

		}else if(board_group.equals("event")) {
			if(searchOption.equals("all")) {
				 noticeService.allNotice(noticeVO);
				return "/admin/articleList";
			}else if(searchOption.equals("board_title")) {
				noticeService.titleNotice(noticeVO);
				return "/admin/articleList";
			}else if(searchOption.equals("board_writer")) {
				noticeService.writerNotice(noticeVO);
				return "/admin/articleList";
			}else if(searchOption.equals("board_content")) {
				noticeService.contentNotice(noticeVO);
				return "/admin/articleList";
			}

			noticeService.updateNotice(noticeVO);
			return "redirect:articleList.mdo?where=event";
		}
		return null;

		
		
	}


}//end class
