package com.thisisthat.admin.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisisthat.admin.category.service.AdminCategoryService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

	@Autowired
	private AdminCategoryService categoryService;
	
	@GetMapping("/productList.mdo")
	public String getProductList(Model model) {
		model.addAttribute("categoryList",categoryService.getCategoryList()); 
		return "/admin/product/productList";
	}
	
	@GetMapping("/insertProduct.mdo")
	public String insertProduct(Model model) {
		model.addAttribute("categoryList",categoryService.getCategoryList());
		return "/admin/product/insertProduct";
	}
	
	
}
