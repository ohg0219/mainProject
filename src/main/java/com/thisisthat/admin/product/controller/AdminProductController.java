package com.thisisthat.admin.product.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thisisthat.admin.product.service.AdminProductService;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.admin.product.vo.AdminProductVO;

@Controller
@RequestMapping("/admin/")
public class AdminProductController {
	
	public AwsS3 awsS3 = AwsS3.getInstance();
	
	@Autowired
	private AdminProductService productService;
	
	@GetMapping("/productList.mdo")
	public String getProductList(Model model) {
		model.addAttribute("categoryList",productService.getCategoryList());
		model.addAttribute("productList",productService.getProductList());
		return "/admin/product/productList";
	}
	
	@GetMapping("/insertProduct.mdo")
	public String insertProductView(Model model) {
		model.addAttribute("categoryList",productService.getCategoryList());
		return "/admin/product/insertProduct";
	}
	
	@PostMapping("/insertProduct.mdo")
	public String insertProduct(MultipartFile mainUploadFile,MultipartFile[] subUploadFile, Model model,AdminProductVO vo) {
		String uploadFolder = "https://thisisthat.s3.ap-northeast-2.amazonaws.com/";
		List<AdminProductImageVO> imageList = new ArrayList<AdminProductImageVO>();
		//메인 이미지 가져오기
		try {
			String key = vo.getProduct_name()+"/"+mainUploadFile.getOriginalFilename();
			InputStream is = mainUploadFile.getInputStream();
			String contentType = mainUploadFile.getContentType();
			long contentLength = mainUploadFile.getSize();
			awsS3.upload(is, key, contentType, contentLength);
			System.out.println("main업로드 완료");
			AdminProductImageVO mainvo = new AdminProductImageVO();
			mainvo.setImage_name(key);
			mainvo.setUpload_path(uploadFolder+key);
			mainvo.setMain_image(1);
			imageList.add(mainvo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//서브 이미지 가져오기
		for(MultipartFile multipartFile : subUploadFile) {
			try {
				String subKey = vo.getProduct_name()+"/"+multipartFile.getOriginalFilename();
				InputStream subIs = multipartFile.getInputStream();
				String subContentType = multipartFile.getContentType();
				long subContentLength = multipartFile.getSize();
				awsS3.upload(subIs, subKey, subContentType, subContentLength);
				System.out.println("sub업로드 완료");
				AdminProductImageVO subvo = new AdminProductImageVO();
				subvo.setImage_name(subKey);
				subvo.setUpload_path(uploadFolder+subKey);
				subvo.setMain_image(0);
				imageList.add(subvo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		productService.insertProduct(vo, imageList);
		return "redirect:/admin/productList.mdo";
	}
	
	@GetMapping("/getProduct.mdo")
	public String getProduct(@RequestParam("productNo")String product_no,Model model) {
		int productNo = Integer.parseInt(product_no);
		model.addAttribute("productInfo",productService.getProduct(productNo));
		List<AdminProductImageVO> imageList = productService.getProductImage(productNo);
		AdminProductImageVO mainImage = new AdminProductImageVO();
		List<AdminProductImageVO> subImage = new ArrayList<AdminProductImageVO>();
		for(AdminProductImageVO image : imageList) {
			if(image.getMain_image()==1) {
				mainImage = image;
			}else {
				subImage.add(image);
			}
		}
		model.addAttribute("mainImage",mainImage);
		model.addAttribute("subImage",subImage);
		
		return "/admin/product/getProduct";
	}
	
	
	
}
