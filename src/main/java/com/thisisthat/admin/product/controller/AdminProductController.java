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
import com.thisisthat.admin.product.vo.AdminProductSizeUsedVO;
import com.thisisthat.admin.product.vo.AdminProductSizeGuideVO;
import com.thisisthat.admin.product.vo.AdminProductVO;
import com.thisisthat.util.PagingVO;

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
	public String getProductList(AdminProductVO vo,
			@RequestParam(value = "searchKeyword", required = false,defaultValue = "") String searchKeyword,
			@RequestParam(value = "nowPage",required = false,defaultValue = "1") String nowPage,
			@RequestParam(value = "category",required = false,defaultValue = "all") String category,
			@RequestParam(value = "check",required = false,defaultValue = "0") String checked,
			
			Model model) {
		if(checked.equals("1")) {
			vo.setProduct_used(1);
		}else {
			vo.setProduct_used(0);
		}
		if(category.equals("all")) {
			vo.setProduct_category(null);
		}else {
			vo.setProduct_category(category);
		}	
		int productCount = productService.getProductCount(vo);
		PagingVO pagingVO = new PagingVO(productCount,Integer.parseInt(nowPage),10);
		model.addAttribute("selectCategory",category);
		model.addAttribute("searchKeyword",searchKeyword);
		model.addAttribute("paging",pagingVO);
		model.addAttribute("checkKey",checked);
		model.addAttribute("categoryList",productService.getCategoryList());
		model.addAttribute("productList",productService.getProductList(pagingVO,vo));
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
	public String insertProduct(
			MultipartFile mainUploadFile,MultipartFile[] subUploadFile, 
			Model model,AdminProductVO vo,AdminProductSizeUsedVO sizeVO,
			@RequestParam(value = "guideSelector")String guideSelector,
			@RequestParam(value = "size1") List<String> size1,@RequestParam(value = "size2") List<String> size2,@RequestParam(value = "size3") List<String> size3,@RequestParam(value = "size4") List<String> size4
			) {
		List<AdminProductSizeGuideVO> sizeGuideList = new ArrayList<AdminProductSizeGuideVO>();
		AdminProductSizeGuideVO guide1 = new AdminProductSizeGuideVO(); AdminProductSizeGuideVO guide2 = new AdminProductSizeGuideVO(); 
		AdminProductSizeGuideVO guide3 = new AdminProductSizeGuideVO(); AdminProductSizeGuideVO guide4 = new AdminProductSizeGuideVO();
		if(guideSelector.equals("top")) {
			guide1.setXs_size(size1.get(0)); guide1.setS_size(size1.get(1)); guide1.setM_size(size1.get(2)); guide1.setL_size(size1.get(3)); guide1.setXl_size(size1.get(4));
			guide2.setXs_size(size2.get(0)); guide2.setS_size(size2.get(1)); guide2.setM_size(size2.get(2)); guide2.setL_size(size2.get(3)); guide2.setXl_size(size2.get(4));
			guide3.setXs_size(size3.get(0)); guide3.setS_size(size3.get(1)); guide3.setM_size(size3.get(2)); guide3.setL_size(size3.get(3)); guide3.setXl_size(size3.get(4));
			guide4.setXs_size(size4.get(0)); guide4.setS_size(size4.get(1)); guide4.setM_size(size4.get(2)); guide4.setL_size(size4.get(3)); guide4.setXl_size(size4.get(4));
			guide1.setGuideSelector(guideSelector); guide2.setGuideSelector(guideSelector); guide3.setGuideSelector(guideSelector); guide4.setGuideSelector(guideSelector);
			guide1.setSize_item("length"); guide2.setSize_item("chest"); guide3.setSize_item("arm"); guide4.setSize_item("shoulder");
		}else {
			guide1.setXs_size(size1.get(0)); guide1.setS_size(size1.get(1)); guide1.setM_size(size1.get(2)); guide1.setL_size(size1.get(3)); guide1.setXl_size(size1.get(4));
			guide2.setXs_size(size2.get(0)); guide2.setS_size(size2.get(1)); guide2.setM_size(size2.get(2)); guide2.setL_size(size2.get(3)); guide2.setXl_size(size2.get(4));
			guide3.setXs_size(size3.get(0)); guide3.setS_size(size3.get(1)); guide3.setM_size(size3.get(2)); guide3.setL_size(size3.get(3)); guide3.setXl_size(size3.get(4));
			guide4.setXs_size(size4.get(0)); guide4.setS_size(size4.get(1)); guide4.setM_size(size4.get(2)); guide4.setL_size(size4.get(3)); guide4.setXl_size(size4.get(4));
			guide1.setGuideSelector(guideSelector); guide2.setGuideSelector(guideSelector); guide3.setGuideSelector(guideSelector); guide4.setGuideSelector(guideSelector);
			guide1.setSize_item("length"); guide2.setSize_item("waist"); guide3.setSize_item("thigh"); guide4.setSize_item("hem");
		}
		sizeGuideList.add(guide1); sizeGuideList.add(guide2); sizeGuideList.add(guide3); sizeGuideList.add(guide4);
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
		
		productService.insertProduct(vo, imageList, sizeGuideList,sizeVO);
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
		String selectSizeGuideGroup = null;
		List<AdminProductSizeGuideVO> sizeGuideList = productService.getProductSizeGuide(productNo);
		for(AdminProductSizeGuideVO size : sizeGuideList) {
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
		System.out.println(selectSizeGuideGroup);
		model.addAttribute("sizeUsed",productService.getProductSizeUsed(productNo));
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
		String selectSizeGuideGroup = null;
		List<AdminProductSizeGuideVO> sizeGuideList = productService.getProductSizeGuide(productNo);
		for(AdminProductSizeGuideVO size : sizeGuideList) {
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
		System.out.println(selectSizeGuideGroup);
		model.addAttribute("sizeUsed",productService.getProductSizeUsed(productNo));
		return "/admin/product/updateProduct";
	}
	/**
	 * 정보 수정 (이미지 제외)
	 * @param vo
	 * @return
	 */
	@PostMapping("/updateProduct.mdo")
	public String updateProduct(AdminProductVO vo,AdminProductSizeUsedVO sizeVO,
			@RequestParam(value = "guideSelector")String guideSelector,
			@RequestParam(value = "size1") List<String> size1,
			@RequestParam(value = "size2") List<String> size2,
			@RequestParam(value = "size3") List<String> size3,
			@RequestParam(value = "size4") List<String> size4) {
		List<AdminProductSizeGuideVO> sizeGuideList = new ArrayList<AdminProductSizeGuideVO>();
		AdminProductSizeGuideVO guide1 = new AdminProductSizeGuideVO(); AdminProductSizeGuideVO guide2 = new AdminProductSizeGuideVO(); 
		AdminProductSizeGuideVO guide3 = new AdminProductSizeGuideVO(); AdminProductSizeGuideVO guide4 = new AdminProductSizeGuideVO();
		if(guideSelector.equals("top")) {
			guide1.setXs_size(size1.get(0)); guide1.setS_size(size1.get(1)); guide1.setM_size(size1.get(2)); guide1.setL_size(size1.get(3)); guide1.setXl_size(size1.get(4));
			guide2.setXs_size(size2.get(0)); guide2.setS_size(size2.get(1)); guide2.setM_size(size2.get(2)); guide2.setL_size(size2.get(3)); guide2.setXl_size(size2.get(4));
			guide3.setXs_size(size3.get(0)); guide3.setS_size(size3.get(1)); guide3.setM_size(size3.get(2)); guide3.setL_size(size3.get(3)); guide3.setXl_size(size3.get(4));
			guide4.setXs_size(size4.get(0)); guide4.setS_size(size4.get(1)); guide4.setM_size(size4.get(2)); guide4.setL_size(size4.get(3)); guide4.setXl_size(size4.get(4));
			guide1.setGuideSelector(guideSelector); guide2.setGuideSelector(guideSelector); guide3.setGuideSelector(guideSelector); guide4.setGuideSelector(guideSelector);
			guide1.setSize_item("length"); guide2.setSize_item("chest"); guide3.setSize_item("arm"); guide4.setSize_item("shoulder");
		}else {
			guide1.setXs_size(size1.get(0)); guide1.setS_size(size1.get(1)); guide1.setM_size(size1.get(2)); guide1.setL_size(size1.get(3)); guide1.setXl_size(size1.get(4));
			guide2.setXs_size(size2.get(0)); guide2.setS_size(size2.get(1)); guide2.setM_size(size2.get(2)); guide2.setL_size(size2.get(3)); guide2.setXl_size(size2.get(4));
			guide3.setXs_size(size3.get(0)); guide3.setS_size(size3.get(1)); guide3.setM_size(size3.get(2)); guide3.setL_size(size3.get(3)); guide3.setXl_size(size3.get(4));
			guide4.setXs_size(size4.get(0)); guide4.setS_size(size4.get(1)); guide4.setM_size(size4.get(2)); guide4.setL_size(size4.get(3)); guide4.setXl_size(size4.get(4));
			guide1.setGuideSelector(guideSelector); guide2.setGuideSelector(guideSelector); guide3.setGuideSelector(guideSelector); guide4.setGuideSelector(guideSelector);
			guide1.setSize_item("length"); guide2.setSize_item("waist"); guide3.setSize_item("thigh"); guide4.setSize_item("hem");
		}
		guide1.setProduct_no(vo.getProduct_no()); guide2.setProduct_no(vo.getProduct_no()); guide3.setProduct_no(vo.getProduct_no()); guide4.setProduct_no(vo.getProduct_no());
		sizeGuideList.add(guide1); sizeGuideList.add(guide2); sizeGuideList.add(guide3); sizeGuideList.add(guide4);
		productService.updateProduct(vo);
		productService.updateProductSizeGuide(sizeGuideList);
		productService.updateProductSizeUsed(sizeVO);
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
		List<AdminProductImageVO> imageList = productService.getProductImage(productNo);
		for(AdminProductImageVO imagevo : imageList) {
			awsS3.delete(imagevo.getImage_name());
		}
		productService.deleteProduct(productNo);
		return "redirect:/admin/productList.mdo";
	}
	
	
}
