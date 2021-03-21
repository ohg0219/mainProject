package com.thisisthat.admin.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisisthat.admin.board.protocol.BoardTypeProtocol;
import com.thisisthat.admin.board.service.BoardService;
import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
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
			search = new SearchVO(BoardTypeProtocol.filter(type), searchType, "%%");
		}else {
			search = new SearchVO(BoardTypeProtocol.filter(type), searchType, parameter);
		}
		int total = boardService.countAnswer(search);
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		vo.setType(BoardTypeProtocol.filter(type));

		List<AnswerBoardVO> answerList = boardService.getAnswerList(vo,search);
		List<AnswerBoardVO> replyList = new ArrayList<AnswerBoardVO>();
		for(AnswerBoardVO answer : answerList) {
			AnswerBoardVO reply = boardService.getReply(answer.getBoardNo());
			if(reply !=null) {
				replyList.add(reply);
			}

		}

		model.addAttribute("type",type);
		model.addAttribute("paging", vo);
		model.addAttribute("answerList",answerList);
		model.addAttribute("replyList",replyList);
		model.addAttribute("search", search);
		return "/admin/answerBoardList";
	}

	@GetMapping("/getAnswer.mdo")
	public String getAnswer(@RequestParam("no")int no, Model model,
			@RequestParam(value="state", required = false)String state) {
		AnswerBoardVO vo = boardService.getAnswer(no);
		if(vo.getBoardState().equals("확인전")) {
			vo.setBoardState("확인중");
		}else if(state != null) {
			vo.setBoardState(state);
		}
		boardService.viewCheck(vo);

		model.addAttribute("answer",vo);
		return "/admin/getAnswer";
	}
	//답변화면 전환
	@GetMapping("/insertReply.mdo")
	public String answer(AnswerBoardVO vo, Model model,RedirectAttributes rttr) {
		AnswerBoardVO reply = boardService.getReply(vo.getBoardNo());
		if(reply == null) {
			model.addAttribute("boardNo",vo.getBoardNo());
			model.addAttribute("boardType",vo.getBoardType());
		}else {
			rttr.addFlashAttribute("msg","msg");
			return "redirect:getAnswer.mdo?no="+vo.getBoardNo();
		}
		return "/admin/insertReply";
	}
	//답변insert
	@PostMapping("/insertReply.mdo")
	public String answerInsert(AnswerBoardVO vo, Model model,HttpSession session,RedirectAttributes rttr) {
		UserVO userVo = (UserVO)session.getAttribute("adminId");
		//질문자의 번호vo.getBoardNo();
		//답변자 아이디 userVo.getUserId();
		AnswerBoardVO reply = boardService.getReply(vo.getBoardNo());
		if(reply == null) {
			vo.setBoardWriter(userVo.getUserId());//답변자 id
			vo.setRegDate(new Date());//지금 시간
			boardService.replyInsert(vo);
			boardService.updateAnswer(vo);
		}else {
			rttr.addFlashAttribute("msg","msg");
			
		}
		return "redirect:getAnswer.mdo?no="+vo.getBoardNo();
	}
	
	@GetMapping("/getReply.mdo")
	public String getReply(@RequestParam("no")int boardNo,
			Model model, RedirectAttributes rttr) {
		if(boardNo >0) {
			AnswerBoardVO vo = boardService.getAnswer(boardNo);
			model.addAttribute("reply",vo);
			return "/admin/getReply";
		}
		rttr.addFlashAttribute("msg","잘못된 요청입니다");
		return "redirect:answerBoardList.mdo";	
		}
	@GetMapping("/updateReply.mdo")
	public String updateReply(AnswerBoardVO vo) {
		boardService.updateReply(vo);
		return "redirect:getReply.mdo?no="+vo.getBoardNo();
	}
	@GetMapping("/deleteReply.mdo")
	public String deleteReply(@RequestParam("boardNo")int boardNo) {
		boardService.deleteReply(boardNo);
		return "redirect:answerBoardList.mdo";
	}
	@GetMapping("/deleteAnswer.mdo")
	public String deleteAnswer(@RequestParam("boardNo")int boardNo) {
		System.out.println(boardNo);
		boardService.deleteAnswer(boardNo);
		AnswerBoardVO reply = boardService.getReply(boardNo);
		if(reply != null) {
			boardService.deleteAnswerReply(boardNo);
		}
		return "redirect:answerBoardList.mdo";
	}
}
