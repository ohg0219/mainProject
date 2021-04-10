package com.thisisthat.user.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.thisisthat.user.register.service.UserRegisterService;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Controller
public class UserSocialLoginOutController {

	@Autowired
	private UserRegisterService userRegisterService;
	
	@RequestMapping("/kakaoAccess.do")
	public String kakaoAccess() {
		return "redirect:https://kauth.kakao.com/oauth/authorize?client_id=7ff3d3c85953e4c8234ff377259bd06b&redirect_uri=http://ec2-13-124-128-58.ap-northeast-2.compute.amazonaws.com/kakaologin.do&response_type=code";
	}
	
	/**
	 * 카카오 로그인하기.
	 * @param code
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/kakaologin.do", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public String kakaoLogin(@RequestParam(value = "code" , required = false) String code,Model model,HttpSession session) throws Exception {
		System.out.println("로그인 할때 임시 코드값");
        //카카오 홈페이지에서 받은 결과 코드
        System.out.println(code);
        System.out.println("로그인 후 결과값");
        JsonNode accessToken;
        
        // JsonNode트리형태로 토큰받아온다
        JsonNode jsonToken = KakaoAuthorizeController.getKakaoAccessToken(code);
        // 여러 json객체 중 access_token을 가져온다
        accessToken = jsonToken.get("access_token");
 
        System.out.println("access_token : " + accessToken);
        JsonNode userInfo = KakaoAuthorizeController.getKakaoUserInfo(accessToken);
        
        // Get id
        String id = userInfo.path("id").asText();
        
        // 유저정보 카카오에서 가져오기 Get properties
        JsonNode properties = userInfo.path("properties");
        JsonNode kakao_account = userInfo.path("kakao_account");
        String name = properties.path("nickname").asText();
        String email = kakao_account.path("email").asText();
        
        UserRegisterVO vo = new UserRegisterVO();
        vo.setId(id+"@k");
        vo.setName(name);
        vo.setEmail(email);
        vo.setPassword(null);
        vo.setNickName(name);
        if(userRegisterService.idCheck(vo.getId())==0) {
        	userRegisterService.insertUser(vo);
        }
        session.setAttribute("kakaoUserId", id+"@k");
        session.setAttribute("userId", id+"@k");
		return "redirect:/main.do";
	}
	/**
	 * 카카오톡 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping("/kakaologout.do")
	public String kakaoLogout(HttpSession session) {
		session.removeAttribute("kakaoUserId");
		session.removeAttribute("userId");
		return "redirect:/main.do";
	}
	
	//============================================================================================
	
	/**
	 * 네이버 로그인콜백 메서드
	 * @return
	 */
	@RequestMapping("/naverLoginResult.do")
	public String naverLoginCallback() {
		return "/user/loginAndRegister/naverLoginCallback";
	}
	
	/**
	 * 네이버 로그인 처리
	 * @param email
	 * @param name
	 * @param uniqId
	 * @param age
	 * @param session
	 * @return
	 */
	@RequestMapping("/naverlogin.do")
	public String naverLogin(
			@RequestParam("email")String email,
			@RequestParam("name")String name,
			@RequestParam("uniqId")String uniqId,
			@RequestParam("age")String age,
			HttpSession session) {
		UserRegisterVO vo = new UserRegisterVO();
        vo.setId(uniqId+"@n");
        vo.setName(name);
        vo.setEmail(email);
        vo.setPassword("");
        vo.setNickName(name);
        if(userRegisterService.idCheck(vo.getId())==0) {
        	userRegisterService.insertUser(vo);
        }
        session.setAttribute("naverUserId", uniqId+"@n");
		session.setAttribute("userId", uniqId+"@n");
		return "redirect:/main.do";
	}
	
	//============================================================================================
	
	/**
	 * 구글 로그인 처리	
	 * @param id
	 * @param name
	 * @param email
	 * @param session
	 * @return
	 */
	@RequestMapping("/googlelogin.do")
	public String googleLogin(@RequestParam("id")String id,
			@RequestParam("name")String name,
			@RequestParam("email")String email,HttpSession session) {
		//회원가입 로직
		UserRegisterVO vo = new UserRegisterVO();
        vo.setId(id+"@g");
        vo.setName(name);
        vo.setEmail(email);
        vo.setPassword("");
        vo.setNickName(name);
        if(userRegisterService.idCheck(vo.getId())==0) {
        	userRegisterService.insertUser(vo);
        }
		session.setAttribute("googleUserId", id+"@g");
		session.setAttribute("userId", id+"@g");
		return "redirect:/main.do";
	}
	
	/**
	 * 구글 로그아웃 처리
	 * @param session
	 * @return
	 */
	@RequestMapping("/googlelogout.do")
	public String googleLogout(HttpSession session) {
		session.removeAttribute("googleUserId");
		session.removeAttribute("userId");
		return "redirect:/main.do";
	}
	
	
}
