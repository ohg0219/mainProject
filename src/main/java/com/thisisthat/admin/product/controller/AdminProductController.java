package com.thisisthat.admin.product.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import com.thisisthat.admin.category.service.AdminCategoryService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	
	public AwsS3 awsS3 = AwsS3.getInstance();
	
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
	@PostMapping("/insertProduct.mdo")
	public void insertProductPost(MultipartFile[] mainUploadFile,MultipartFile[] subUploadFile, Model model) {
		String uploadFolder = "https://thisisthat.s3.ap-northeast-2.amazonaws.com/";
		int i = 1;
		int j = 1;
		for(MultipartFile multipartFile : mainUploadFile) {
			try {
				String key = multipartFile.getOriginalFilename();
				InputStream is = multipartFile.getInputStream();
				String contentType = multipartFile.getContentType();
				long contentLength = multipartFile.getSize();
				//awsS3.upload(is, key, contentType, contentLength);
				System.out.println("main업로드 완료");
				System.out.println(i+" : "+key);
				i++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(MultipartFile multipartFile : subUploadFile) {
			try {
				String key = multipartFile.getOriginalFilename();
				InputStream is = multipartFile.getInputStream();
				String contentType = multipartFile.getContentType();
				long contentLength = multipartFile.getSize();
				//awsS3.upload(is, key, contentType, contentLength);
				System.out.println("sub업로드 완료");
				System.out.println(j+" : "+key);
				j++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
}
