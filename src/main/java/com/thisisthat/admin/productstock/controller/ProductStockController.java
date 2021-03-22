package com.thisisthat.admin.productstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisisthat.admin.productstock.service.ProductStockService;
import com.thisisthat.admin.productstock.vo.ProductStockVO;

@Controller
@RequestMapping("/admin/*")
public class ProductStockController {

	@Autowired
	private ProductStockService productStockService;
	
	@RequestMapping("productStockList.mdo")
	public String getProductStockList(Model model) {
		ProductStockVO productStockVO = new ProductStockVO();
		List<ProductStockVO> prodcutStockList = productStockService.stockList(productStockVO);
		
		model.addAttribute("prodcutStockList", prodcutStockList);
		return "/admin/product_stock/productStockList";
	}
}
