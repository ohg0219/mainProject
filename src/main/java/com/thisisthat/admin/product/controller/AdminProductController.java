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
	
	/**
	 * 상품 리스트 보기 + 카테고리 셀랙트 버튼 목록추가
	 * @param model
	 * @return
	 */
	@GetMapping("/productList.mdo")
	public String getProductList(Model model) {
		model.addAttribute("categoryList",productService.getCategoryList());
		model.addAttribute("productList",productService.getProductList());
		return "/admin/product/productList";
	}
	
	/**
	 * 상품등록페이지로 이동 + 카테고리 사용 상태인 목록만 추가
	 * @param model
	 * @return
	 */
	@GetMapping("/insertProduct.mdo")
	public String insertProduct(Model model) {
		model.addAttribute("categoryList",productService.getCategoryList());
		return "/admin/product/insertProduct";
	}
	
	/**
	 * 상품등록 이미지파일은 AWSS3 에 업로드
	 * @param mainUploadFile
	 * @param subUploadFile
	 * @param model
	 * @param vo
	 * @return
	 */
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
	
	/**
	 * 상품 상세보기
	 * @param product_no
	 * @param model
	 * @return
	 */
	@GetMapping("/getProduct.mdo")
	public String getProduct(@RequestParam("productNo")String product_no,Model model) {
		int productNo = Integer.parseInt(product_no);
		model.addAttribute("productInfo",productService.getProduct(productNo));
		model.addAttribute("productStock",productService.getProductStock(productNo));
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
	
	/**
	 * 정보 수정 페이지 (이미지 제외)
	 * @param product_no
	 * @param model
	 * @return
	 */
	@GetMapping("/updateProduct.mdo")
	public String updateProductView(@RequestParam("productNo")String product_no,Model model) {
		//첨부파일 수정시 첨부파일 어떻게 할지
		// 1. 첨부파일 전부 삭제 후 재업로드 (재업로드 시 이미지들에 대한 고려)
		// 2. 수정된 부분만 검사해서 추가 / 제거 (검사방법에 대한 고민)
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
		return "/admin/product/updateProduct";
	}
	/**
	 * 정보 수정 (이미지 제외)
	 * @param vo
	 * @return
	 */
	@PostMapping("/updateProduct.mdo")
	public String updateProduct(AdminProductVO vo) {
		productService.updateProduct(vo);
		return "redirect:/admin/getProduct.mdo?productNo="+ vo.getProduct_no();
	}
	
	/**
	 * 메인 이미지 수정 페이지 (상세 이미지 제외)
	 * @param product_no
	 * @param model
	 * @return
	 */
	@GetMapping("/updateMainImage.mdo")
	public String updateMainImageView(@RequestParam("product_no")String product_no,Model model) {
		int productNo = Integer.parseInt(product_no);
		model.addAttribute("productInfo",productService.getProduct(productNo));
		List<AdminProductImageVO> imageList = productService.getProductImage(productNo);
		List<AdminProductImageVO> subImage = new ArrayList<AdminProductImageVO>();
		for(AdminProductImageVO image : imageList) {
			if(image.getMain_image()==1) {
			
			}else {
				subImage.add(image);
			}
		}
		model.addAttribute("subImage",subImage);
		return "/admin/product/updateMainImage";
	}
	
	@PostMapping("/updateMainImage.mdo")
	public String updateMainImage(@RequestParam("product_no")String product_no, MultipartFile mainUploadFile,Model model,AdminProductVO vo) {
		int productNo = Integer.parseInt(product_no);
		model.addAttribute("productInfo",productService.getProduct(productNo));
		List<AdminProductImageVO> productImage = productService.getProductImage(productNo);
		for(AdminProductImageVO imageVO : productImage) {
			if(imageVO.getMain_image()==1) {
				awsS3.delete(imageVO.getImage_name());
			}
		}
		String uploadFolder = "https://thisisthat.s3.ap-northeast-2.amazonaws.com/";
		try {
			String key = vo.getProduct_name()+"/"+mainUploadFile.getOriginalFilename();
			InputStream is = mainUploadFile.getInputStream();
			String contentType = mainUploadFile.getContentType();
			long contentLength = mainUploadFile.getSize();
			awsS3.upload(is, key, contentType, contentLength);
			AdminProductImageVO mainvo = new AdminProductImageVO();
			mainvo.setProduct_no(productNo);
			mainvo.setImage_name(key);
			mainvo.setUpload_path(uploadFolder+key);
			mainvo.setMain_image(1);
			productService.updateMainImage(mainvo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/getProduct.mdo?productNo="+productNo;
	}
	
	/**
	 * 상세 이미지 수정
	 * @param product_no
	 * @param model
	 * @return
	 */
	@GetMapping("/updateSubImage.mdo")
	public String updateSubImageView(@RequestParam("product_no")String product_no,Model model) {
		int productNo = Integer.parseInt(product_no);
		model.addAttribute("productInfo",productService.getProduct(productNo));
		List<AdminProductImageVO> imageList = productService.getProductImage(productNo);
		AdminProductImageVO mainImage = new AdminProductImageVO();
		for(AdminProductImageVO image : imageList) {
			if(image.getMain_image()==1) {
				mainImage = image;
			}
		}
		model.addAttribute("mainImage",mainImage);
		return "/admin/product/updateSubImage";
	}
	
	@PostMapping("/updateSubImage.mdo")
	public String updateSubImage(@RequestParam("product_no")String product_no, MultipartFile[] subUploadFile,Model model,AdminProductVO vo) {
		int productNo = Integer.parseInt(product_no);
		model.addAttribute("productInfo",productService.getProduct(productNo));
		List<AdminProductImageVO> productImage = productService.getProductImage(productNo);
		for(AdminProductImageVO imageVO : productImage) {
			if(imageVO.getMain_image()==0) {
				awsS3.delete(imageVO.getImage_name());
			}
		}
		productService.deleteSubImage(productNo);
		String uploadFolder = "https://thisisthat.s3.ap-northeast-2.amazonaws.com/";
		//서브 이미지 가져오기
		for(MultipartFile multipartFile : subUploadFile) {
			try {
				String subKey = vo.getProduct_name()+"/"+multipartFile.getOriginalFilename();
				InputStream subIs = multipartFile.getInputStream();
				String subContentType = multipartFile.getContentType();
				long subContentLength = multipartFile.getSize();
				awsS3.upload(subIs, subKey, subContentType, subContentLength);
				AdminProductImageVO subvo = new AdminProductImageVO();
				subvo.setProduct_no(productNo);
				subvo.setImage_name(subKey);
				subvo.setUpload_path(uploadFolder+subKey);
				subvo.setMain_image(0);
				productService.insertSubImage(subvo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/admin/getProduct.mdo?productNo="+productNo;
	}
	
	@GetMapping("/deleteProduct.mdo")
	public String deleteProduct(@RequestParam("product_no")String product_no) {
		long productNo = Long.parseLong(product_no);
		//aws s3 파일 삭제
		List<AdminProductImageVO> imageList = productService.getProductImage(productNo);
		for(AdminProductImageVO imagevo : imageList) {
			awsS3.delete(imagevo.getImage_name());
		}
		//db 삭제
		productService.deleteProduct(productNo);
		return "redirect:/admin/productList.mdo";
	}
	
	
}
