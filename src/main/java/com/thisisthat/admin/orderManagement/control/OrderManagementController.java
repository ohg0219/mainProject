package com.thisisthat.admin.orderManagement.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisisthat.admin.orderManagement.service.OrderManagementService;
import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;

@Controller
@RequestMapping("/admin/*")
public class OrderManagementController {
	
	@Autowired
	private OrderManagementService orderManagementService;
	
	@GetMapping("getOrderManagementList.mdo")
	public String oredrManagementlist(Model model ) {
		OrderManagementVO orderManagementVO = new OrderManagementVO();
		List<OrderManagementVO> orderList = orderManagementService.orderList(orderManagementVO);
		model.addAttribute("orderList", orderList);
		
		
		return "/admin/orderManagement/orderManagementList";
		
	}

}
