package com.thisisthat.admin.productstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.productstock.service.ProductStockService;
import com.thisisthat.admin.productstock.vo.ProductStockVO;

@Controller
@RequestMapping("/admin/*")
public class ProductStockController {

	@Autowired
	private ProductStockService productStockService;
	


	@RequestMapping("getStockList.mdo")
	public String productStockList(Model model,@RequestParam(value="searchOption")String searchOption,ProductStockVO productStockVO,@RequestParam(value="keyword")String keyword){
		if(searchOption.equals("all")) {

			productStockVO.setKeyword(keyword);
			
			List<ProductStockVO> prodcutStockList = productStockService.allList(productStockVO);

			model.addAttribute("prodcutStockList", prodcutStockList);
			return "/admin/product_stock/productStockList";
		}else if(searchOption.equals("product_no")) {
			System.out.println(searchOption);
			productStockVO.setKeyword(keyword);
			List<ProductStockVO> prodcutStockList = productStockService.productnoList(productStockVO);

			model.addAttribute("prodcutStockList", prodcutStockList);
			return "/admin/product_stock/productStockList";
		}else if(searchOption.equals("product_name")) {
			productStockVO.setKeyword(keyword);
			List<ProductStockVO> prodcutStockList = productStockService.productnameList(productStockVO);

			model.addAttribute("prodcutStockList", prodcutStockList);
			return "/admin/product_stock/productStockList";
		}
			
			return null;

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
	public String updateProductStock(@RequestParam(value="product_no")int product_no, @RequestParam(value="xs")int xs, @RequestParam(value="s")int s, @RequestParam(value="m")int m, @RequestParam(value="l")int l, @RequestParam(value="xl")int xl, ProductStockVO productStockVO) {
		productStockService.updateStock(productStockVO);
		
		
		return "redirect:productStockList.mdo";
	}

}// end class
