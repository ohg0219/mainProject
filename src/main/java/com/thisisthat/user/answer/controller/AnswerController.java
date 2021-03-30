package com.thisisthat.user.answer.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.admin.product.controller.AwsS3;
import com.thisisthat.user.answer.service.AnswerService;
import com.thisisthat.user.answer.vo.SearchVO;
import com.thisisthat.util.PagingVO;

@Controller
public class AnswerController {

	public AwsS3 awsS3 = AwsS3.getInstance();



	@Autowired
	AnswerService answerService;
	@GetMapping("/answerList.do")
	public String answerList(Model model,  PagingVO vo, HttpSession session,
			
			@RequestParam(value = "msg", required = false)String msg,
			@RequestParam(value = "nowPage", required = false)String nowPage,
			@RequestParam(value = "searchKeyword", required = false)String searchKeyword,
			@RequestParam(value = "searchType",required = false)String searchType,
			@RequestParam(value = "searchDate",required = false)String searchDate) {

		SearchVO searchvo;

		if (nowPage == null) nowPage = "1";

		if(searchType == null) searchType = "all";
		if(searchDate == null) searchDate = "all";

		if(searchKeyword == null)searchvo = new SearchVO(searchDate, searchType, "all");
		else searchvo = new SearchVO(searchDate, searchType, searchKeyword);

		int total = answerService.total(searchvo);
		vo = new PagingVO(total, Integer.parseInt(nowPage), 15);
		vo.setType(searchType);

		List<AnswerBoardVO> answerList = answerService.getAnswerList(vo,searchvo);
		List<AnswerBoardVO> replyList = new ArrayList<AnswerBoardVO>();
		if(answerList != null) {
			for(AnswerBoardVO answer : answerList) {
				AnswerBoardVO reply = answerService.getReply(answer.getBoardNo());
				if(reply !=null) {
					replyList.add(reply);
				}
			}
		}

		if((String)session.getAttribute("userId") == null) {
			model.addAttribute("userId", "noId");
		}else {
			model.addAttribute("userId", (String)session.getAttribute("userId"));
		}
		if(msg !=null) model.addAttribute("msg","msg");
		
		model.addAttribute("searchType",searchType);
		model.addAttribute("searchDate",searchDate);
		model.addAttribute("searchKeyword",searchKeyword);
		model.addAttribute("answerList",answerList);
		model.addAttribute("replyList",replyList);
		model.addAttribute("paging", vo);

		return "/user/answer/answerList";
	}
	@GetMapping("/insertAnswer.do")
	public String insertAnser(
			AnswerBoardVO vo, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:answerList.do";
		}		
		return "/user/answer/insertAnswer";
	}
	@PostMapping("/insertAnswer.do")
	public String insertAnswer(MultipartFile[] img, AnswerBoardVO vo,HttpSession session) {

		String uploadFolder = "https://thisisthat.s3.ap-northeast-2.amazonaws.com/";
		int seq = answerService.getSeq();
		vo.setBoardNo(seq);
		//------------------------------파일 업로드---------------------------
		try {
			if(img[0].getSize() != 0) {
				String key = seq+img[0].getOriginalFilename();
				InputStream is = img[0].getInputStream();
				String contentType = img[0].getContentType();
				long contentLength = img[0].getSize();
				awsS3.upload(is, key, contentType, contentLength);
				vo.setBoardImg1(uploadFolder+key);
				if(img[1].getSize() != 0) {
					key = seq+img[1].getOriginalFilename();
					is = img[1].getInputStream();
					contentType = img[1].getContentType();
					contentLength = img[1].getSize();
					awsS3.upload(is, key, contentType, contentLength);
					vo.setBoardImg2(uploadFolder+key);
					if(img[2].getSize() != 0) {
						key = seq+img[2].getOriginalFilename();
						is = img[2].getInputStream();
						contentType = img[2].getContentType();
						contentLength = img[2].getSize();
						awsS3.upload(is, key, contentType, contentLength);
						vo.setBoardImg3(uploadFolder+key);
						if(img[3].getSize() != 0) {
							key = seq+img[3].getOriginalFilename();
							is = img[3].getInputStream();
							contentType = img[3].getContentType();
							contentLength = img[3].getSize();
							awsS3.upload(is, key, contentType, contentLength);
							vo.setBoardImg4(uploadFolder+key);
						}//3
					}//2
				}//1
			}//0
		}catch (IOException e) {
			e.printStackTrace();
		}
		//------------------------------파일 업로드end---------------------------

		vo.setBoardWriter((String)session.getAttribute("userId"));
		vo.setRegDate(new Date());
		answerService.insertAnswer(vo);
		return "/user/answer/answerList";
	}

	@GetMapping("/getAnswer.do")
	public String getAnswer(int boardNo, Model model,HttpSession session, RedirectAttributes attr) {
		String userId = (String)session.getAttribute("userId");
		AnswerBoardVO vo= answerService.getAnswer(boardNo);
		if(!vo.isBoardSecret() || vo.getBoardWriter().equals(userId)) {
		model.addAttribute("answer",vo);
		return "user/answer/getAnswer";
		}else {
			attr.addFlashAttribute("msg", "msg");
			return "redirect:answerList.do";
		}
		
				
	}
}
