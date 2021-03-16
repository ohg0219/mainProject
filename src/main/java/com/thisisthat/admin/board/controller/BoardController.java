package com.thisisthat.admin.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.board.protocol.BoardTypeProtocol;
import com.thisisthat.admin.board.service.BoardService;
import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/answerBoardList.mdo")
	public String answerBoardList(Model model, PagingVO vo,
								  @RequestParam(value="type", required = false)String type,
								  @RequestParam(value="nowPage", required = false)String nowPage,
								  @RequestParam(value="cntPerPage", required = false)String cntPerPage,
								  @RequestParam(value="searchType", required = false)String searchType,
								  @RequestParam(value="parameter", required = false)String parameter) {
		
		if(type==null) type="all";
		SearchVO search;
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		if(searchType == null) searchType="선택없음";
		if(parameter == null) {
			System.out.println("파라미터없음");
			search = new SearchVO(BoardTypeProtocol.filter(type), searchType, "%%");
		}else {
			search = new SearchVO(BoardTypeProtocol.filter(type), searchType, parameter);
		}
		
		System.out.println(search.getParameter());
		int total = boardService.countAnswer(search);
		System.out.println(search.getParameter());
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		System.out.println(search.getParameter());
		vo.setType(BoardTypeProtocol.filter(type));
		System.out.println(search.getParameter());
		model.addAttribute("type",type);
		System.out.println(search.getParameter());
		model.addAttribute("paging", vo);
		System.out.println(search.getParameter());
		model.addAttribute("answerList",boardService.getAnswerList(vo,search));
		System.out.println(search.getParameter());
		model.addAttribute("search", search);
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
