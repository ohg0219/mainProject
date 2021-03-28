package com.thisisthat.user.address.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.address.service.AddressService;
import com.thisisthat.user.address.vo.AddressVO;

@Controller
public class AddressController {

	@Autowired
	private AddressService service;
	
	@GetMapping("/mypage/address.do")
	public String getAddress(AddressVO vo, Model model, HttpSession session	) {
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		List<AddressVO> getAddress = service.getAddressList(vo);
		model.addAttribute("addressList", getAddress);
		return "/user/mypage/getAddress";
	}
	
	// 주소지 추가 화면으로 가기
	@GetMapping("/addressAdd.do")
	public String addressAdd(AddressVO vo) {
		return "/user/mypage/addressAdd";
	}
	
	// insert 기능 수행
	@PostMapping("/addressInsert.do")
	public String addressInsert(AddressVO vo, HttpSession session,
									@RequestParam(value="userPhone1") String phone1,
									@RequestParam(value="userPhone2") String phone2,
									@RequestParam(value="userPhone3") String phone3 ) {
		vo.setUserPhone(phone1 + phone2 + phone3);
		String userId =  (String) session.getAttribute("userId");
		vo.setUserId(userId);
		service.addressInsert(vo);
		return "redirect:/mypage/address.do";
	}
	
	// 주소지 수정 화면으로 가기 
	@PostMapping("/addressModify.do")
	public String addressModify(AddressVO vo, Model model, @RequestParam(value="no") int No	) {		
		vo.setAddressNo(No);
		AddressVO address =  service.getAddress(vo);
		String phone2 = address.getUserPhone().substring(3, 7);
		String phone3 = address.getUserPhone().substring(7, 11);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		model.addAttribute("modify", address);
		return "/user/mypage/addressModify";
	}
	
	// update 기능 수행
	@PostMapping("/addressUpdate.do")
	public String addressUpdate(AddressVO vo, @RequestParam(value="userPhone1") String phone1,
								@RequestParam(value="userPhone2") String phone2, @RequestParam(value="userPhone3") String phone3) {
		System.out.println(vo.toString());
		vo.setUserPhone(phone1 + phone2 + phone3);
		service.addressUpdate(vo);
		return "redirect:/mypage/address.do";
	}
	
	// delete 기능 수행
	@GetMapping("/addressDelete.do")
	public String addressDelete(@RequestParam(value="no") int addressNo) {
		System.out.println(addressNo);
		service.addressDelete(addressNo);
		return "redirect:/mypage/address.do";
	}
	
	
		
}