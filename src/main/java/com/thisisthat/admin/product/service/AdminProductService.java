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

	List<AdminCategoryVO> getCategoryList();
	int getProductCount(AdminProductVO vo);

	void insertProduct(AdminProductVO vo,List<AdminProductImageVO> imageList,List<AdminProductSizeGuideVO> sizeGuideList,AdminProductSizeUsedVO sizeVO);
	void updateProduct(AdminProductVO vo);
	void deleteProduct(long productNo);
	AdminProductVO getProduct(long productNo);
	List<AdminProductListVO> getProductList(PagingVO pagingVO,AdminProductVO vo);
	List<AdminProductImageVO> getProductImage(long productNo);

	long getProductStock(long productNo);

	void updateMainImage(AdminProductImageVO vo);
	void insertSubImage(AdminProductImageVO vo);
	void deleteSubImage(long productNo);
	
	List<AdminProductSizeGuideVO> getProductSizeGuide(long productNo);
	AdminProductSizeUsedVO getProductSizeUsed(long productNo);
	void updateProductSizeGuide(AdminProductVO vo,List<AdminProductSizeGuideVO> sizeGuideList);
	void updateProductSizeUsed(AdminProductSizeUsedVO sizeVO);
	
	
}
