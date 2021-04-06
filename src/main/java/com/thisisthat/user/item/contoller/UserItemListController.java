package com.thisisthat.user.item.contoller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.thisisthat.admin.product.controller.AwsS3;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.user.item.service.UserItemListService;
import com.thisisthat.user.item.vo.CommentVO;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemSizeGuideVO;
import com.thisisthat.util.PagingVO;

@Controller
public class UserItemListController {

	AwsS3 awsS3 = AwsS3.getInstance();
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
			Model model, HttpSession session) {
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
		
        if(session.getAttribute("productNo") != null) {
            List<Integer> list = (List<Integer>) session.getAttribute("productNo");
            if(!list.contains(productNo)) {
                list.add(productNo);
                session.setAttribute("productNo", list);
            }
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(productNo);
            session.setAttribute("productNo", list);
        }
		
		model.addAttribute("selectSizeGuideGroup",selectSizeGuideGroup);
		model.addAttribute("sizeUsed",itemListService.getItemSizeUsed(productNo));
		model.addAttribute("itemInfo",itemListService.getItemInfo(productNo));
		model.addAttribute("itemImage",itemListService.getItemImage(productNo));
		model.addAttribute("category",productCategory);
		return "/user/item/getItem";
	}
	@PostMapping("/itemList/comment.do")
	public String comment(HttpSession session, MultipartFile[] uploadFile, String content
			, int productNo, String category) {
		System.out.println(content);
		System.out.println(uploadFile.length);
		String uploadFolder = "https://thisisthat.s3.ap-northeast-2.amazonaws.com/";
		CommentVO comment = new CommentVO();
		comment.setContent(content);
		comment.setRegDate(new Date());
		comment.setBoardNo(productNo);
		comment.setWriter((String)session.getAttribute("userId"));
		if(uploadFile[0].getSize() != 0) {
			String[] temp = new String[uploadFile.length];
			for(int i =0; i<uploadFile.length; i++) {
				try {
					String Key = ((String)session.getAttribute("userId"))+"/"+uploadFile[i].getOriginalFilename();
					InputStream Is = uploadFile[i].getInputStream();
					String ContentType = uploadFile[i].getContentType();
					long ContentLength = uploadFile[i].getSize();
					awsS3.upload(Is, Key, ContentType, ContentLength);
					temp[i] = uploadFolder+Key;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			comment.setImg(temp);
		}
		itemListService.insertComment(comment);
		return "redirect:/itemList/getItem.do?productCategory="+category+"&productNo="+productNo;
	}

	@RequestMapping("/itemList/commentList.do")
	@ResponseBody
	public Map<String, Object> getBoardReplyList(
			@RequestParam(value = "boardNo") int boardNo,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) {

		PagingVO paging = new PagingVO(itemListService.commentCount(boardNo), page, 10);
		Map<String,Object> datas = new HashMap<String, Object>();
		datas.put("paging", paging);
		datas.put("commentList", itemListService.getCommentList(paging, boardNo));


		return datas;
	}
	@PostMapping("/itemList/delComment.do")
	@ResponseBody
	public void delComment(@RequestParam(value = "commentNo")int commentNo) {
		itemListService.delComment(commentNo);
		
		
	}
	
}
