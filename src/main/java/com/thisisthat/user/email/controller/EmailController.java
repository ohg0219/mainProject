package com.thisisthat.user.email.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
								Model model ) throws Exception {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", pwEmail);
		paramMap.put("name", name);
		paramMap.put("id", id);
		
		String user_pw = service.getPwEmail(paramMap);
		int pw = (int)(Math.random()*100000000);
		if (user_pw != null) {

			StringBuffer ms =  new StringBuffer();
			ms.append("<html><body><h1>Hello</h1></body></html>");
			ms.append("[임시 비밀번호 발급]\n\nthisisthat 계정의 비밀번호가 변경되었습니다.\n");
			ms.append(name + "님의 임시 비밀번호는 [" + pw + "] 입니다.\n비밀번호 변경을 원하지 않으셨거나, 요청하지 않은 경우 고객센터로 연락주시기 바랍니다.\n");
			ms.append("감사합니다.\n\n-thisisthat 계정팀-");
			
			email.setContent(ms.toString()); // 내용
			email.setReceiver(pwEmail); // 수신자
			email.setSubject(pwEmail + "님 비밀번호 찾기 메일입니다."); // 제목
			emailSender.SendEmail(mailSender, email); // 보내기!
			
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
	
	@GetMapping("/updatePw.do")
	public String updatePw(Map<String, Object> map,
							@RequestParam(value="id")String id,
							@RequestParam(value="pw", required=false)String pw,
							UserRegisterVO vo) {
		vo.setPassword(BCrypt.hashpw(pw, BCrypt.gensalt()));
		map.put("id", id);
		map.put("pass", vo.getPassword());
		service.updatePw(map);
		return "redirect:/login.do";
	}
	
	
	
	
	
}