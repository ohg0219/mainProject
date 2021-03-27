package com.thisisthat.user.email.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
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

import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.email.Email;
import com.thisisthat.user.email.EmailSender;
import com.thisisthat.user.email.service.EmailService;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Controller
public class EmailController {
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private JavaMailSenderImpl senderImpl;
	
	@Autowired
	EmailService service;

	// 이메일을 이용하여 아이디 찾기
	@GetMapping("/sendIdEmail.do")
	public String sendIdEmailAction (	@RequestParam(value="name") String name, 
										@RequestParam(value="email") String email,
										Model model, UserVO vo ) throws Exception {	

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("email", email);
		
		List<String> userId = service.getIdEmail(map);
		
		if(userId.isEmpty()) { 
			model.addAttribute("errType", "mailSendingFail");
			model.addAttribute("errMsg", "입력하신 정보로 가입된 회원은 존재하지 않습니다.");
			return "/user/findFail";
		
		} else {
			StringBuffer ms = new StringBuffer();
			ms.append("<h1>" + name + "님 안녕하세요.</h1> \n회원님의 계정 아이디를 알려드립니다. \n회원님의 아이디는\n");
			for(String id : userId) {
				ms.append("[" + id + "]\n");
			}
			ms.append("입니다.\n\n 감사합니다.\n-thisisthat 계정팀-");
			ms.append("</body>\\r\\n\\r\n</html>");
			String realMs= ms.toString();
			
			this.email.setReceiver(email);
			this.email.setContent(realMs); // 내용
			this.email.setSubject(name + "님, 아이디가 도착했습니다."); // 제목
			emailSender.SendEmail(mailSender, this.email); // 보내기!		

			model.addAttribute("errType", "mailSendingComplete");
			model.addAttribute("errMsg", email + " 로 요청하신 정보의 전송이 완료 되었습니다.");
			return "/user/findView";
		}	
	}
	
	// 이메일로 비밀번호 찾기
	@RequestMapping("/sendPwEmail.do")
	public String findPwEmail ( @RequestParam(value="email") String pwEmail,
								@RequestParam(value="name") String name,
								@RequestParam(value="id") String id,
								HttpSession session,
								Model model ) throws Exception {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", pwEmail);
		paramMap.put("name", name);
		paramMap.put("id", id);
		
		String user_pw = service.getPwEmail(paramMap);
		int pw = (int)(Math.random()*100000000);
		String bcryptPw =  BCrypt.hashpw(String.valueOf(pw), BCrypt.gensalt());
		System.out.println("bcryptPw : " + bcryptPw);
		if (user_pw != null) {	
			session.setAttribute("userPw", bcryptPw);
			StringBuffer ms =  new StringBuffer();
			String url = "http://localhost:8080/changePw.do?pw="+ bcryptPw + "&id=" + id;
			ms.append("<html><body>");
			ms.append("<img src='https://thisisthat.s3.ap-northeast-2.amazonaws.com/img/mainlogo.png' style='width:150px' alt='[thisisthat]'><br>");
			ms.append("<br><strong>&nbsp;[비밀번호 재설정]</strong><br><br>");
			ms.append("&nbsp;" + name + "님,<br>&nbsp;비밀번호를 잊으셨습니까?</body></html><br><br>&nbsp;");
			ms.append("<a style='border-bottom: 1px solid #111;' href=" + url + "> &#8618; 비밀번호 재설정</a>");
	//		ms.append(name + "님의 임시 비밀번호는 [" + pw + "] 입니다.<br>비밀번호 변경을 원하지 않으셨거나, 요청하지 않은 경우 고객센터로 연락주시기 바랍니다.<br>");
			ms.append("<br>&nbsp;감사합니다.<br><br>&nbsp;-thisisthat 계정팀-");
			ms.append("</html></body>");
			final MimeMessagePreparator preparator = new MimeMessagePreparator() { 
				@Override public void prepare(MimeMessage mimeMessage) throws Exception { 
					final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 
					helper.setTo(pwEmail);
					helper.setSubject(pwEmail + "님 계정 암호 재설정");
					helper.setText(ms.toString(), true);
					}
				};
		/*		
			MimeMessageHelper helper = new MimeMessageHelper();
			email.setContent(ms.toString()); // 내용
			email.set
			email.setReceiver(pwEmail); // 수신자
			email.setSubject(pwEmail + "님 비밀번호 찾기 메일입니다."); // 제목
			emailSender.SendEmail(mailSender, email); // 보내기!
		 */
			senderImpl.send(preparator); // 보내기!
			
			model.addAttribute("errType", "mailSendingComplete");
			model.addAttribute("errMsg", pwEmail + " 로 새로운 비밀번호가 전송되었습니다.");
			model.addAttribute("id", id);
			model.addAttribute("pass", pw);
			return "/user/findPw";
			
		} else {
			// 메시지 띄우고 해당 페이지 그대로 놔두기
			model.addAttribute("errType", "mailSendingFail");
			model.addAttribute("errMsg", "입력하신 정보로 가입된 회원은 존재하지 않습니다.");
			return "/user/findFail";
		}
	}
	
	@GetMapping("/changePw.do")
	public String changePw(@RequestParam(value="pw") String bcryptPw,
							@RequestParam(value="id") String id,
								Model model, HttpSession session) {	
		if(session.getAttribute("userPw") != null) {
			
			if (session.getAttribute("userPw").equals(bcryptPw)) {
				model.addAttribute("id" , id);
				return "/user/changePw";
				
			} else {
				model.addAttribute("errType", "mailSendingComplete");
				model.addAttribute("errMsg", "잘못된 요청입니다.");
				return "/user/findFail";
			}			
			
		} else {
			model.addAttribute("errType", "mailSendingComplete");
			model.addAttribute("errMsg", "잘못된 세션입니다.");
			return "/user/findFail";
		}		
	}
	
	
	
	@PostMapping("/updatePw.do")
	public String updatePw(Map<String, Object> map,
							@RequestParam(value="id")String id,
							@RequestParam(value="password", required=false)String pw,
							UserRegisterVO vo) {
		
		vo.setPassword(BCrypt.hashpw(pw, BCrypt.gensalt()));
		map.put("id", id);
		map.put("pass", vo.getPassword());
		service.updatePw(map);
		return "redirect:/login.do";
	}
	
	
	
	
}