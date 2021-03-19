package com.thisisthat.admin.product.service;

import java.util.List;

import com.thisisthat.admin.category.vo.AdminCategoryVO;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.admin.product.vo.AdminProductListVO;
import com.thisisthat.admin.product.vo.AdminProductSizeGuideVO;
import com.thisisthat.admin.product.vo.AdminProductSizeUsedVO;
import com.thisisthat.admin.product.vo.AdminProductVO;
import com.thisisthat.util.PagingVO;

public interface AdminProductService {

	void insertProduct(AdminProductVO vo,List<AdminProductImageVO> imageList,List<AdminProductSizeGuideVO> sizeGuideList,AdminProductSizeUsedVO sizeVO);
	List<AdminCategoryVO> getCategoryList();
	List<AdminProductListVO> getProductList(PagingVO pagingVO,AdminProductVO vo);
	AdminProductVO getProduct(long productNo);
	List<AdminProductImageVO> getProductImage(long productNo);
	long getProductStock(long productNo);
	
	List<AdminProductSizeGuideVO> getProductSizeGuide(long productNo);
	AdminProductSizeUsedVO getProductSizeUsed(long productNo);
	
	
	
	
	void deleteProduct(long productNo);
	void updateProduct(AdminProductVO vo);
	void updateMainImage(AdminProductImageVO vo);
	void deleteSubImage(long productNo);
	void insertSubImage(AdminProductImageVO vo);
	
	int getProductCount(AdminProductVO vo);
}
