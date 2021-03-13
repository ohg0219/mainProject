package com.thisisthat.admin.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.board.service.BoardService;
import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/answerBoardList.mdo")
	public String answerBoardList(Model model, PagingVO vo,
								  @RequestParam(value="type",defaultValue="")String type,
								  @RequestParam(value="nowPage", required = false)String nowPage,
								  @RequestParam(value="cntPerPage", required = false)String cntPerPage) {
		int total = boardService.countAnswer();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("answerList",boardService.getAnswerList(vo));
		return "/admin/answerBoardList";
	}
	
	@GetMapping("/getAnswer.mdo")
	public String getAnswer(@RequestParam("no")int no, Model model) {
		
		AnswerBoardVO vo = boardService.getAnswer(no);
		model.addAttribute("answer",vo);
		if(vo.getBoardState().equals("답글")) {
			model.addAttribute("msg","admin");
		}else {			
			model.addAttribute("msg","normal");
		}
		
		return "/admin/getAnswer";
	}
}
