package com.thisisthat.admin.terms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.terms.service.TermsService;
import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.email.EmailSender;
import com.thisisthat.user.email.vo.Email;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin")
public class TermsController {

	@Autowired
	TermsService termsService;

	@Autowired
	private Email email;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private JavaMailSenderImpl senderImpl;

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
	public String insertTerms(String content, String state, String corrections) {
		String terms;
		if(state.equals("information")) {
			InformationVO information = new InformationVO();
			information.setContent(content);
			termsService.insertInformation(information);
			terms = "개인정보 수집 및 이용 약관";
		}else {
			UtilizationVO utilization = new UtilizationVO();
			utilization.setContent(content);
			termsService.insertUtilization(utilization);
			terms = "이용 약관";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date today = new Date();
		for(UserVO vo : termsService.getUserList()) {
			StringBuffer ms = new StringBuffer();
			ms.append("<h1>thisisthat 서비스  "+terms+" 개정 안내</h1> <br><br><br>");
			ms.append("안녕하세요. thisisthat 서비스팀입니다.<br>");
			ms.append("thisisthat 서비스를 이용해 주시는 회원님께 진심으로 감사드립니다.<br>");
			ms.append(format.format(today)+" 자로 thisisthat "+terms+"을 개정함에 따라 회원님께 주요 개정 내용을 알려드립니다. 주요 개정 내용은 아래와 같습니다<br>");
			ms.append("<strong>주요 개정 내용</strong><br><br><br><br>");
			ms.append(corrections+"<br><br>");
			ms.append("-thisisthat 서비스팀-<br>");
			ms.append("</body></html>");
			final MimeMessagePreparator preparator = new MimeMessagePreparator() { 
				@Override 
				public void prepare(MimeMessage mimeMessage) throws Exception { 
				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 
				helper.setTo(vo.getUserEmail().trim());
				helper.setSubject("thisisthat 서비스 "+terms+" 개정 안내");
				helper.setText(ms.toString(), true);
				}
			};
			senderImpl.send(preparator); // 보내기!
		
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
