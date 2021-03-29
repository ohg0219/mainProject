package com.thisisthat.admin.banner.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisisthat.admin.banner.service.BannerService;
import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.admin.product.controller.AwsS3;
import com.thisisthat.admin.product.vo.AdminProductImageVO;

@Controller
@RequestMapping("/admin")
public class BannerController {
	AwsS3 awsS3 = AwsS3.getInstance();
	
	@Autowired
	BannerService bannerService;
	
	@GetMapping("/getBanner.mdo")
	public String getBanner(Model model,
			@RequestParam(value = "msg", required = false)String msg) {
		
		if(msg != null) model.addAttribute("msg",msg);
		model.addAttribute("bannerList",bannerService.getBannerList());
		return "/admin/banner/getBanner";
	}
	@GetMapping("/insertBanner.mdo")
	public String insertBanner() {
		
		return "/admin/banner/insertBanner";
	}
	
	
	@PostMapping("/insertBanner.mdo")
	public String insertBanner(MultipartFile mainUploadFile, BannerVO banner) {
		String uploadFolder = "https://thisisthat.s3.ap-northeast-2.amazonaws.com/";
		String key = null;
		try {
			key = banner.getBannerName()+"/"+mainUploadFile.getOriginalFilename();
			InputStream is = mainUploadFile.getInputStream();
			String contentType = mainUploadFile.getContentType();
			long contentLength = mainUploadFile.getSize();
			awsS3.upload(is, key, contentType, contentLength);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		banner.setBannerUri(uploadFolder+key);
		bannerService.insertBanner(banner);
		
		
		return "redirect:/admin/getBanner.mdo";
	}
	
	@GetMapping("/bannerOrder.mdo")
	public String bannerOrder(
			@RequestParam("bannerOrder")List<Integer> bannerOrder,
			RedirectAttributes attr) {
		List<BannerVO> bannerList = bannerService.getBannerList();
		
		//순서 중복체크
		for(int i = 0; i<bannerOrder.size(); i++) {
			bannerList.get(i).setBannerOrder(bannerOrder.get(i));
			for(int j = i+1; j<bannerOrder.size(); j++) {
				if(bannerOrder.get(i) == bannerOrder.get(j)) {
					System.out.println("중복!");
					attr.addFlashAttribute("msg","fail");
					return "redirect:/admin/getBanner.mdo";
				}
			}
		}//순서 중복체크end
		bannerService.updateOrder(bannerList);
		
		attr.addFlashAttribute("msg","success");
		return "redirect:/admin/getBanner.mdo";
	}
	@GetMapping("/deleteBanner.mdo")
	public String deleteBanner(@RequestParam("bannerOrder")int bannerOrder,RedirectAttributes attr) {
		bannerService.deleteBanner(bannerOrder);
		attr.addFlashAttribute("msg","success");
		return "redirect:/admin/getBanner.mdo";
	}
}
