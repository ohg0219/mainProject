package com.thisisthat.admin.terms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.terms.service.TermsService;
import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin")
public class TermsController {

	@Autowired
	TermsService termsService;

	@GetMapping("/getTermsList.mdo")
	public String getTerms(@RequestParam(value="state", required = false)String state,
			@RequestParam(value="nowPage", required = false)Integer nowPage,
			Model model) {
		PagingVO pagingVO;
		if(state == null) return "redirect:/admin/main.mdo";
		if(nowPage == null) nowPage = 1;
		if(state.equals("information")) {
			pagingVO = new PagingVO(termsService.getInformationTotal(), nowPage, 15); 
			List<InformationVO> Terms = termsService.getInformationList(pagingVO);
			model.addAttribute("termsList",Terms);
		}else {
			pagingVO = new PagingVO(termsService.getUtilizationTotal(), nowPage, 15); 
			List<UtilizationVO> Terms = termsService.getUtilizationList(pagingVO);
			model.addAttribute("termsList",Terms);
		}
		model.addAttribute("paging",pagingVO);
		model.addAttribute("state",state);
		return "/admin/terms/getTermsList";
	}
	@PostMapping("/insertTerms.mdo")
	public String insertTerms(String content, String state) {
		
		if(state.equals("information")) {
			InformationVO information = new InformationVO();
			information.setContent(content);
			termsService.insertInformation(information);
		}else {
			UtilizationVO utilization = new UtilizationVO();
			utilization.setContent(content);
			termsService.insertUtilization(utilization);
		}

		return "redirect:/admin/getTermsList.mdo?state="+state;
	}

	@GetMapping("/insertTerms.mdo")
	public String insertTerms(@RequestParam(value = "state", required = false)String state,
			Model model) {
		if(state ==null) return "redirect:/admin/main.mdo";

		model.addAttribute("state",state);
		return "/admin/terms/insertTerms";
	}
	@GetMapping("/getTerms.mdo")
	public String getTerms(@RequestParam(value="state")String state,
			@RequestParam(value="no")int no,
			Model model) {
		if(state.equals("information")) {
			InformationVO terms = termsService.getInformation(no);
			model.addAttribute("terms",terms);
		}else {
			UtilizationVO terms = termsService.getUtilization(no);
			model.addAttribute("terms",terms);
		}
		model.addAttribute("state",state);
		return "/admin/terms/getTerms";
	}
}
