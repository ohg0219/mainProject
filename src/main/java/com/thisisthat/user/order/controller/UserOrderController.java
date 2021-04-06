package com.thisisthat.user.order.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.order.service.UserOrderService;
import com.thisisthat.user.order.vo.UserOrderVO;
import com.thisisthat.util.PagingVO;

@Controller
public class UserOrderController {

	@Autowired
	private UserOrderService service;
	
	/**
	 * 회원 주문 목록
	 * @param session
	 * @param model
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	@GetMapping("/mypage/orderlist.do")
	public String getOrderList(HttpSession session,Model model,
			@RequestParam(value = "sDate",required = false) String sDate,
			@RequestParam(value = "eDate",required = false) String eDate,
			@RequestParam(value = "nowPage",required = false,defaultValue = "1") String nowPage) {
		UserOrderVO vo = new UserOrderVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(sDate!=null&&eDate!=null) {
			try {
				vo.setsDate(sdf.parse(sDate));
				vo.seteDate(sdf.parse(eDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		int orderCount = service.getOrderCount(vo);
		PagingVO pagingVO = new PagingVO(orderCount,Integer.parseInt(nowPage),10);
		List<UserOrderVO> orderList = service.getOrderList(vo,pagingVO);
		model.addAttribute("orderList",orderList);
		model.addAttribute("paging",pagingVO);
		model.addAttribute("sDate",sDate);
		model.addAttribute("eDate",eDate);
		return "/user/mypage/orders";
	}
	/**
	 * 회원 주문 상세
	 * @param orderNo
	 * @param model
	 * @return
	 */
	@GetMapping("/mypage/getorder.do")
	public String getOrder(@RequestParam("orderNo") int orderNo,Model model) {
		List<UserOrderVO> orderList = service.getOrder(orderNo);
		UserOrderVO vo = orderList.get(0);
		model.addAttribute("order",vo);
		model.addAttribute("orderList",orderList);
		return "/user/mypage/getOrder";
	}
	
	
	@GetMapping("/orders.do")
	public String orderDivide(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/nonMemberOrder.do";
		}else {
			return "redirect:/mypage/orderlist.do";
		}
	}
	
	@GetMapping("/nonMemberOrder.do")
	public String nonMemberOrder() {
		return "/user/mypage/nonMemberOrder";
	}
	
	/**
	 * 비회원 주문조회 결과
	 * @param name
	 * @param orderNo
	 * @param password
	 * @param model
	 * @return
	 */
	@PostMapping("/searchOrder.do")
	public String getNonMemberOrder(
			@RequestParam("name") String name,
			@RequestParam("orderNo") int orderNo,
			@RequestParam("password") String password,
			Model model) {
		String dbPass = service.getPassword(orderNo);
		if(dbPass != null) {
			if(BCrypt.checkpw(password, dbPass)) {
				List<UserOrderVO> orderList = service.getOrder(orderNo);
				UserOrderVO vo = orderList.get(0);
				model.addAttribute("order",vo);
				model.addAttribute("orderList",orderList);
				return "/user/mypage/getOrder";
			}else {
				return "/user/mypage/orderCheckFail";
			}
		}else {
			return "/user/mypage/orderCheckFail";
		}
	}
	
	@GetMapping("/mypage/updateState.do")
	public String updateState(
			@RequestParam("orderNo") int orderNo,
			@RequestParam("state") String state,
			HttpSession session, Model model) {
		service.updateState(orderNo, state);
		List<UserOrderVO> orderList = service.getOrder(orderNo);
		UserOrderVO vo = orderList.get(0);
		model.addAttribute("order",vo);
		model.addAttribute("orderList",orderList);
		return "/user/mypage/getOrder";
	}
	
	
}
