package com.thisisthat.admin.orderManagement.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.orderManagement.service.OrderManagementService;
import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;

@Controller
@RequestMapping("/admin/*")
public class OrderManagementController {
	
	@Autowired
	private OrderManagementService orderManagementService;
	
	@RequestMapping("getOrderManagementList.mdo")
	public String oredrManagementlist(Model model ) {
		OrderManagementVO orderManagementVO = new OrderManagementVO();
		List<OrderManagementVO> orderList = orderManagementService.orderList(orderManagementVO);
		model.addAttribute("orderList", orderList);
		
		return "/admin/orderManagement/orderManagementList";
	}
	
	@RequestMapping("getOrderManagement.mdo")
	public String getOrderManagement(Model model, @RequestParam(value="order_no")int order_no) {
		OrderManagementVO orderManagementVO = new OrderManagementVO();
		orderManagementVO.setOrder_no(order_no);
		
		List<OrderManagementVO> getOrder = orderManagementService.getOrder(orderManagementVO);
		model.addAttribute("getorder", getOrder);
		return "/admin/orderManagement/getOrderManagement";
	}

}//end class
