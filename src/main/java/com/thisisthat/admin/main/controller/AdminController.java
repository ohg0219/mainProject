package com.thisisthat.admin.main.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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

import com.thisisthat.admin.main.service.AdminService;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.email.EmailSender;
import com.thisisthat.user.email.vo.Email;

@Controller

public class AdminController {

	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private JavaMailSenderImpl senderImpl;


	@Autowired
	AdminService dao;


	@RequestMapping("/admin/404.mdo")
	public String test() {
		return "/admin/404";
	}

	@RequestMapping("/admin/main.mdo")
	public String mainView(Model model) {
		DecimalFormat df = new DecimalFormat("###,###");
		model.addAttribute("thisMonthSales",df.format(dao.getThisMonthSales()));
		model.addAttribute("thisDaySales",df.format(dao.getThisDaySales()));
		model.addAttribute("noAnswerCount",dao.noAnswerCount());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> dateListString = new ArrayList<>();
		List<Date> dateList = new ArrayList<Date>();
		for(int i = 6;i>=0;i--) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -i);
			dateListString.add(sdf.format(cal.getTime()));
			dateList.add(cal.getTime());
		}
		model.addAttribute("dateList",dateListString);
		model.addAttribute("dataList",dao.getOneWeekSales(dateList));
		model.addAttribute("todayCategorySales",dao.getTodayCatgorySales());
		return "/admin/main";
	}

	@RequestMapping("/login.mdo")
	public String loginView() {
		return "/admin/login";
	}
	@RequestMapping("/admin/logout.mdo")
	public String removeSession(HttpSession session, HttpServletResponse response) {
		Cookie cookie = new Cookie("userVO", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		session.invalidate();
		return "/admin/login";
	}
	@RequestMapping("/findPassword.mdo")
	public String removeSession() {
		return "/admin/findPassword";
	}

	//id, email 비교 후 메일 발송
	@PostMapping("/findPassword.mdo")
	public String findPassword(UserVO user,Model model, HttpSession session){
		System.out.println(user);
		if(dao.userCheck(user)) {
			int pw = (int)(Math.random()*100000000);
			String bcryptPw = BCrypt.hashpw(String.valueOf(pw), BCrypt.gensalt());
			session.setAttribute(user.getUserId() , bcryptPw);
			StringBuffer ms =  new StringBuffer();
			String url = "http://ec2-13-124-128-58.ap-northeast-2.compute.amazonaws.com/resetPassword.mdo?pw="+ bcryptPw + "&id=" + user.getUserId();
			ms.append("<html><body>");
			ms.append("<img src='https://thisisthat.s3.ap-northeast-2.amazonaws.com/img/mainlogo.png' style='width:150px' alt='[thisisthat]'><br>");
			ms.append("<br><strong>&nbsp;[비밀번호 재설정]</strong><br><br>");
			ms.append("&nbsp;" + user.getUserId() + "님,<br>&nbsp;비밀번호를 잊으셨습니까?</body></html><br><br>&nbsp;");
			ms.append("<a style='border-bottom: 1px solid #111;' href=" + url + "> &#8618; 비밀번호 재설정</a>");

			ms.append("<br>&nbsp;감사합니다.<br><br>&nbsp;-thisisthat 계정팀-");
			ms.append("</html></body>");
			final MimeMessagePreparator preparator = new MimeMessagePreparator() { 
				@Override public void prepare(MimeMessage mimeMessage) throws Exception { 
					final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 
					helper.setTo(user.getUserEmail());
					helper.setSubject(user.getUserEmail() + "님 계정 암호 재설정");
					helper.setText(ms.toString(), true);
				}
			};

			senderImpl.send(preparator); // 보내기!
			model.addAttribute("msg","발송 성공!");
			return "/admin/login";
		}
		model.addAttribute("msg","이메일 또는 아이디를 확인해 주세요.");
		return "/admin/login";
	}

	@GetMapping("/resetPassword.mdo")
	public String resetPassword(@RequestParam(value = "pw", required = false)String pw,
			@RequestParam(value = "id", required = false)String id,
			HttpSession session, Model model) {
		String pwParam = (String)session.getAttribute(id);
		if(pwParam != null && pw != null && id != null && pwParam.equals(pw)) {
			
			model.addAttribute("id",id);
			return "/admin/resetPassword";
		}
		model.addAttribute("msg", "비정상 요청입니다");
		return "/admin/login";

	}


	@PostMapping("/login.mdo")
	public String loginCheck(UserVO vo, HttpSession session,Model model,
			@RequestParam(value="autoLogin",defaultValue= "false")boolean autoLogin,
			HttpServletResponse response) {
		UserVO user = dao.idCheck(vo.getUserId());
		if(user == null) {

		}else if(BCrypt.checkpw(vo.getUserPw(), user.getUserPw())) {
			if(user.getUserRole()<21) {
				session.setAttribute("adminId", user);
				if(autoLogin) {
					Cookie cookie = new Cookie("userVO", user.getUserId());
					cookie.setMaxAge(60*60*24*30);//한달설정
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				return "redirect:/admin/main.mdo";
			}else {
				model.addAttribute("msg","권한이 없습니다");
				return "/admin/login";
			}
		}

		model.addAttribute("msg","아이디, 비밀번호를 확인해 주세요.");
		return "/admin/login";
	}




	@GetMapping("userManagement.mdo")
	public String userManagement() {

		return "/admin/userManagement";
	}
	@PostMapping("/resetPassword.mdo")
	public String resetPassword(Model model, UserVO user, HttpSession session) {
		session.removeAttribute(user.getUserId());
		user.setUserPw(BCrypt.hashpw(user.getUserPw(), BCrypt.gensalt()));
		dao.updateUser(user);
		model.addAttribute("msg","비밀번호 변경 성공");
		return "/admin/login";
	}
}
