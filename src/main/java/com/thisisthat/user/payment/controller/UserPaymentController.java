package com.thisisthat.user.payment.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.basket.vo.UserBasketItemVO;
import com.thisisthat.user.payment.service.UserPaymentService;
import com.thisisthat.user.payment.vo.UserBasketVO;
import com.thisisthat.user.payment.vo.UserMailVO;
import com.thisisthat.user.payment.vo.UserPaymentVO;
import com.thisisthat.user.payment.vo.UserVO;

@Controller
public class UserPaymentController {

	@Autowired
	UserPaymentService paymentService;

	@Autowired
	private JavaMailSenderImpl senderImpl;
	
	/**
	 * 결제하기 버튼 클릭시 세션 검사 후 회원과 비회원 페이지 분리
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/paymentDivide.do")
	public String paymentView(HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			//회원 재고 < 선택수량
			String userId = (String) session.getAttribute("userId");
			if(paymentService.userBasketOrderCount(userId)) {
				return "redirect:/memberPayment.do"; // 회원결제가기
			}else{
				return "/user/payment/paymentFail"; //재고 < 선택수량 
			}
		}else {
			List<UserBasketItemVO> basketItem = (List<UserBasketItemVO>) session.getAttribute("basketItem");
			if(paymentService.nonMemberBasketOrderCount(basketItem)) {
				return "/user/payment/nonMember"; //비회원결제가기
			}else {
				return "/user/payment/paymentFail"; //재고 < 선택수량 
			}
		}
	}
	
	/**
	 * 회원 결제 페이지 진입
	 * @param session
	 * @param model
	 * @return
	 */
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
	
	/**
	 * 회원 결제완료 
	 * @param phone1
	 * @param phone2
	 * @param phone3
	 * @param originalPrice
	 * @param vo
	 * @param session
	 * @param model
	 * @return
	 */
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
		mailSend(orderNo);
		
		return "/user/payment/paymentResult";
	}
	
	/**
	 * 비회원 결제 페이지 진입
	 * @param session
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/nonMemberPayment.do")
	public String nonMemberPayment(HttpSession session,Model model) {
		List<UserBasketItemVO> basketItem = (List<UserBasketItemVO>) session.getAttribute("basketItem");
		int productPrice = 0;
		String str ="thisisthat_";
		for(int i =0;i<basketItem.size();i++) {
			productPrice+=basketItem.get(i).getProductPrice()*basketItem.get(i).getSelectCount();
			str += String.valueOf(basketItem.get(i).getProductNo())+",";
		}
		model.addAttribute("subTotal",productPrice);
		model.addAttribute("productList",str.substring(0, str.length()-1));
		return "/user/payment/nonMemberPayment";
	}
	
	/**
	 * 비회원 결제 완료
	 * @param phone1
	 * @param phone2
	 * @param phone3
	 * @param orderPassword
	 * @param vo
	 * @param session
	 * @param model
	 * @return
	 */
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
		mailSend(orderNo);
		session.removeAttribute("basketItem");
		return "/user/payment/paymentResult";
	}
	
	/**
	 * 결제완료 이메일 발송
	 */
	String userId = "";
	public void mailSend(int orderNo) {
		UserPaymentVO orderInfo = paymentService.userOrder(orderNo);
		Date orderDate = orderInfo.getOrderDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<UserMailVO> orderProductInfo = paymentService.userOrderInfo(orderNo);
		StringBuffer sb = new StringBuffer();
		DecimalFormat df = new DecimalFormat("###,###");
		if(orderInfo.getUserId().equals("비회원")) {
			userId = orderInfo.getReceiveName()+"[비회원]";
		}else {
			userId = orderInfo.getUserId();
		}
		sb.append("<html><body>");
		sb.append("<div style='font: 500 11px/1.5 arial, sans-serif; border:1px solid #444;padding: 20px;width: 500px;'>");
		sb.append("<p>안녕하세요. <strong>thisisthat</strong> 입니다.</p><br>");
		sb.append("<p><strong>"+userId+"</strong>고객님께서 <strong>thisisthat</strong>에서 주문하신 내역입니다. </p><br><br>");
		sb.append("<p>"+userId+"</p>");
		sb.append("<p>주문번호</p>");
		sb.append("<p>"+orderNo+"</p>");
		sb.append("<p>주문일</p>");
		sb.append("<p>"+sdf.format(orderDate)+"</p><br><br>");
		sb.append("<p>주문 상품 정보</p>");
		sb.append("<table border='1' style='border-collapse: collapse; text-align: center; '> ");
		sb.append("<tr>");
		sb.append("<td width='100px'>상품명</th>");
		sb.append("<td width='50px'>사이즈</th>");
		sb.append("<td width='50px'>수량</th>");
		sb.append("<td width='100px'>판매가</th>");
		sb.append("<td width='100px'>상품구매금액</th>");
		sb.append("</tr>");
		for(UserMailVO mailvo : orderProductInfo) {
			sb.append("<tr>");
			sb.append("<td>"+mailvo.getProductName()+"</td>");
			sb.append("<td>"+mailvo.getOrderSize()+"</td>");
			sb.append("<td>"+mailvo.getSelectCount()+"</td>");
			sb.append("<td>"+df.format(mailvo.getProductPrice())+"</td>");
			sb.append("<td>"+df.format(mailvo.getProductTotal())+"</td>");
			sb.append("</tr>");
		}
		sb.append("<tr>");
		sb.append("<td colspan='5'>총 상품구매금액 "+df.format(orderInfo.getOriginalPrice())+" + 총 배송비 0 - "
					+ "할인금액 "+df.format((orderInfo.getUsePoint()+orderInfo.getUseCoupon()))+" <br>= 총 결제금액 "+df.format(orderInfo.getOrderPrice())+"</td>");
		sb.append("</tr>");
		sb.append("</table><br><br>");
		sb.append("<p>결제 정보</p><br>");
		sb.append("<table border='1' style='border-collapse: collapse;text-align: center;'>");
		sb.append("<tr>");
		sb.append("<td width='100px'>총 결제 금액</td>");
		sb.append("<td width='100px'>"+df.format(orderInfo.getOrderPrice())+"</td>");
		sb.append("<td width='100px'>결제수단</td>");
		sb.append("<td width='100px'>"+orderInfo.getOrderSelect()+"</td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</body></html>");
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
				helper.setTo(orderInfo.getOrderEmail());
				helper.setSubject("[thisisthat] "+userId+" 님의 주문 내역을 알려드립니다. ");
				helper.setText(sb.toString(),true);
			}
		};
		senderImpl.send(preparator);	
	}
}
