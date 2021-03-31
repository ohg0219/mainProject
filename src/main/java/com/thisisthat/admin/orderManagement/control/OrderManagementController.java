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
	
	@RequestMapping("selectOrderManagementList.mdo")
	public String selectOrderManagementlist(@RequestParam(value="order_state")String order_state, OrderManagementVO orderManagementVO, @RequestParam(value="order_no")String order_no) {
		orderManagementVO.setOrder_no(Integer.parseInt(order_no));
		orderManagementVO.setOrder_state(order_state);
		
		orderManagementService.selectOrder_start(orderManagementVO);
		
		return "redirect:getOrderManagementList.mdo";
	}
	@RequestMapping("selectOrderManagement.mdo")
	public String selectOrderManagement(@RequestParam(value="order_state")String order_state, OrderManagementVO orderManagementVO, @RequestParam(value="order_no")String order_no,@RequestParam(value="invoice_no")String invoice_no) {
		orderManagementVO.setInvoice_no(Integer.parseInt(invoice_no));
		orderManagementVO.setOrder_no(Integer.parseInt(order_no));
		orderManagementVO.setOrder_state(order_state);
		orderManagementService.selectOrder(orderManagementVO);
		
		return "redirect:getOrderManagementList.mdo";
	}
	
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
