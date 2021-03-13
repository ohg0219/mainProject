package com.thisisthat.admin.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.category.service.AdminCategoryService;
import com.thisisthat.admin.category.vo.AdminCategoryVO;

@Controller
public class AdminCategoryController {

	@Autowired
	private AdminCategoryService categoryService;
	
	@RequestMapping("/categoryList.mdo")
	public String getCategoryList(Model model) {
		List<AdminCategoryVO> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList",categoryList);
		return "/admin/category/categoryList";
	}
	
	@GetMapping("/getCategory.mdo")
	public String getCategory(@RequestParam("categorySeq")int categorySeq,Model model) {
		model.addAttribute("category",categoryService.getCategory(categorySeq));
		return "/admin/category/getCategory";
	}
	
	
	
	@GetMapping("/insertCategory.mdo")
	public String insertCategoryView() {
		return "/admin/category/insertCategory";
	}
	
	@PostMapping("/insertCategory.mdo")
	public String insertCategory(AdminCategoryVO vo) {
		categoryService.insertCategory(vo);
		return "redirect:/categoryList.mdo";
	}
	
	@PostMapping("/updateCategory.mdo")
	public String updateCategory(AdminCategoryVO vo) {
		System.out.println(vo.toString());
		categoryService.updateCategory(vo);
		return "redirect:/categoryList.mdo";
	}
	
	@RequestMapping("/deleteCategory.mdo")
	public String deleteCategory(@RequestParam("categorySeq")int categorySeq) {
		categoryService.deleteCategory(categorySeq);
		return "redirect:/categoryList.mdo";
	}
	
}
