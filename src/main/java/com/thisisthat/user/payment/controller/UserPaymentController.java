package com.thisisthat.user.payment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.basket.vo.UserBasketItemVO;
import com.thisisthat.user.payment.service.UserPaymentService;
import com.thisisthat.user.payment.vo.UserBasketVO;
import com.thisisthat.user.payment.vo.UserPaymentVO;
import com.thisisthat.user.payment.vo.UserVO;

@Controller
public class UserPaymentController {

	@Autowired
	UserPaymentService paymentService;
	
	//결제하기 버튼 클릭시 세션검사후 회원, 비회원 분리
	@GetMapping("/paymentDivide.do")
	public String paymentView(HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			return "redirect:/memberPayment.do";
		}else {
			return "/user/payment/nonMember";
		}
	}
	
	//회원결제페이지
	@GetMapping("/memberPayment.do")
	public String memberPayment(HttpSession session,Model model) {
		String userId = (String) session.getAttribute("userId");
		UserVO userVO = paymentService.getUserInfo(userId);
		if(userVO.getUserPhone()!=null) {
			String phoneAll = userVO.getUserPhone();
			userVO.setPhone1(phoneAll.substring(0, 3));
			userVO.setPhone2(phoneAll.substring(3, 7));
			userVO.setPhone3(phoneAll.substring(7));
		}
		List<UserBasketVO> getBasketList = paymentService.getBasketList(userId);
		String str ="thisisthat_";
		for(int i = 0;i<getBasketList.size();i++) {
			str += String.valueOf(getBasketList.get(i).getProductNo())+",";
		}
		model.addAttribute("productList",str.substring(0, str.length()-1));
		model.addAttribute("userInfo",userVO);
		model.addAttribute("subTotal",paymentService.getUserBasketPrice(userId));
		model.addAttribute("basketPoint",paymentService.basketPointSum(userId));
		model.addAttribute("userPoint",paymentService.getUserPoint(userId));
		return "/user/payment/memberPayment";
	}
	
	//회원 결제 완료
	@PostMapping("/memberPayment.do")
	public String memberPayment(
			@RequestParam("phone1")String phone1,
			@RequestParam("phone2")String phone2,
			@RequestParam("phone3")String phone3,
			@RequestParam("originalPrice") int originalPrice,
			UserPaymentVO vo,HttpSession session,Model model
			) {
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		vo.setReceivePhone(phone1+phone2+phone3);
		vo.setOrderDate(new Date());
		vo.setOrderPrice(vo.getOriginalPrice()-vo.getUsePoint()-vo.getUseCoupon());
		vo.setWaitingPoint(paymentService.basketPointSum(userId));
		if(vo.getOrderSelect().equals("카카오페이")) {
			vo.setOrderState("결제완료");
		}else if(vo.getOrderSelect().equals("무통장")) {
			vo.setOrderState("입금대기");
		}
		//쿠폰 테이블 미적용
		if(vo.getUsePoint()>0) {
			paymentService.insertUsePoint(vo);
		}
		int orderNo = paymentService.insertOrder(vo);
		model.addAttribute("orderNo",orderNo);
		model.addAttribute("orderDate",paymentService.getOrderDate(orderNo));
		return "/user/payment/paymentResult";
	}
	
	//비회원결제페이지
	@SuppressWarnings("unchecked")
	@GetMapping("/nonMemberPayment.do")
	public String nonMemberPayment(HttpSession session,Model model) {
		List<UserBasketItemVO> basketItem = (List<UserBasketItemVO>) session.getAttribute("basketItem");
		int productPrice = 0;
		String str ="thisisthat_";
		for(int i =0;i<basketItem.size();i++) {
			productPrice+=basketItem.get(i).getProductPrice();
			str += String.valueOf(basketItem.get(i).getProductNo())+",";
		}
		model.addAttribute("subTotal",productPrice);
		model.addAttribute("productList",str.substring(0, str.length()-1));
		return "/user/payment/nonMemberPayment";
	}
	
	//비회원 결제완료
	@SuppressWarnings("unchecked")
	@PostMapping("/nonMemberPayment.do")
	public String nonMemberPayment(@RequestParam("phone1")String phone1,
			@RequestParam("phone2")String phone2,
			@RequestParam("phone3")String phone3,
			@RequestParam(value = "orderPassword")String orderPassword,
			UserPaymentVO vo,HttpSession session,Model model) {
		List<UserBasketItemVO> sessionBasket = (List<UserBasketItemVO>) session.getAttribute("basketItem");
		vo.setOrderPassword(BCrypt.hashpw(vo.getOrderPassword(), BCrypt.gensalt()));
		vo.setReceivePhone(phone1+phone2+phone3);
		vo.setOrderDate(new Date());
		vo.setOrderPrice(vo.getOriginalPrice());
		vo.setUserId("비회원");
		if(vo.getOrderSelect().equals("카카오페이")) {
			vo.setOrderState("결제완료");
		}else if(vo.getOrderSelect().equals("무통장")) {
			vo.setOrderState("입금대기");
		}
		int orderNo = paymentService.insertNonMemberOrder(vo, sessionBasket);
		model.addAttribute("orderNo",orderNo);
		model.addAttribute("orderDate",paymentService.getOrderDate(orderNo));
		return "/user/payment/paymentResult";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
