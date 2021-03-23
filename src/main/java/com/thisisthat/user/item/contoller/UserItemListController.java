package com.thisisthat.user.item.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.item.service.UserItemListService;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemSizeGuideVO;

@Controller
public class UserItemListController {

	
	@Autowired
	private UserItemListService itemListService;
	/**
	 * 상품 리스트 페이지로 이동
	 * @param category
	 * @return
	 */
	@GetMapping("/itemList/category/{category}.do")
	public String itemListView(@PathVariable String category,Model model) {
		List<UserItemListVO> itemList = itemListService.getItemList(category);
		model.addAttribute("itemList",itemList);
		model.addAttribute("category",category);
		return "/user/item/itemList";
	}
	
	@GetMapping("/itemList/getItem.do")
	public String getItem(
			@RequestParam("productNo") int productNo,
			@RequestParam("productCategory")String productCategory,
			Model model) {
		String selectSizeGuideGroup = null;
		List<UserItemSizeGuideVO> sizeGuideList = itemListService.getItemSizeGuide(productNo);
		for(UserItemSizeGuideVO size : sizeGuideList) {
			String select = size.getSize_item();
			if(select.equals("chest")) {
				selectSizeGuideGroup = "top";
			}else if(select.equals("waist")) {
				selectSizeGuideGroup = "bottom";
			}
			switch (select) {
			case "length":model.addAttribute("length", size);break;
			case "chest":model.addAttribute("chest", size);break;
			case "arm":model.addAttribute("arm", size);break;
			case "shoulder":model.addAttribute("shoulder", size);break;
			case "waist":model.addAttribute("waist", size);break;
			case "thigh":model.addAttribute("thigh", size);break;
			case "hem":model.addAttribute("hem", size);break;
			}
		}
		model.addAttribute("selectSizeGuideGroup",selectSizeGuideGroup);
		model.addAttribute("sizeUsed",itemListService.getItemSizeUsed(productNo));
		model.addAttribute("itemInfo",itemListService.getItemInfo(productNo));
		model.addAttribute("itemImage",itemListService.getItemImage(productNo));
		model.addAttribute("category",productCategory);
		return "/user/item/getItem";
	}
	
}
