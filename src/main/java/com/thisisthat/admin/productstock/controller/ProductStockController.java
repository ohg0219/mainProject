package com.thisisthat.admin.productstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.productstock.service.ProductStockService;
import com.thisisthat.admin.productstock.vo.ProductStockVO;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin/*")
public class ProductStockController {

	@Autowired
	private ProductStockService productStockService;
	


	@RequestMapping("getStockList.mdo")
	public String productStockList(Model model,
			@RequestParam(value="searchOption",defaultValue = "all")String searchOption,
			@RequestParam(value="nowPage", required = false)Integer nowPage,
			ProductStockVO productStockVO){
		if(nowPage == null) nowPage = 1;
		if(searchOption.equals("product_name")) {
			productStockVO.setProduct_category("all");
		}else {
			productStockVO.setProduct_category(searchOption);
		}
		PagingVO paging = new PagingVO(productStockService.getCount(productStockVO,searchOption), nowPage, 15);
		List<ProductStockVO> prodcutStockList = productStockService.poductStockList(productStockVO,searchOption, paging);
		model.addAttribute("keyword",productStockVO.getKeyword());
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("paging",paging);
		model.addAttribute("prodcutStockList", prodcutStockList);
		return "/admin/product_stock/productStockList";

	}



	@RequestMapping("getProductStockList.mdo")
	public String getProductStockList(Model model) {
		ProductStockVO productStockVO = new ProductStockVO();
		List<ProductStockVO> prodcutStockList = productStockService.stockList(productStockVO);

		model.addAttribute("prodcutStockList", prodcutStockList);
		return "/admin/product_stock/productStockList";
	}// 재고관리 리스트

	@RequestMapping("getProductStock.mdo")
	public String getProductStock(Model model,@RequestParam(value="product_no")int product_no, ProductStockVO productStockVO) {
	
		productStockVO.setProduct_no(product_no);
		ProductStockVO getStock =  productStockService.getStock(productStockVO);

		model.addAttribute("article", getStock);
		return "/admin/product_stock/productStock";
	}//상세보기

	@RequestMapping("updateStock.mdo")
	public String updateProductStock(
			@RequestParam(value="product_no")int product_no, 
			@RequestParam(value="xs",defaultValue = "0")int xs, 
			@RequestParam(value="s",defaultValue = "0")int s, 
			@RequestParam(value="m",defaultValue = "0")int m, 
			@RequestParam(value="l",defaultValue = "0")int l, 
			@RequestParam(value="xl",defaultValue = "0")int xl, 
			ProductStockVO productStockVO) {
		productStockService.updateStock(productStockVO);
		return "redirect:/admin/getStockList.mdo";
	}

}// end class
