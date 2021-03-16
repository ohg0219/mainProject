package com.thisisthat.admin.product.service;

import java.util.List;

import com.thisisthat.admin.category.vo.AdminCategoryVO;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.admin.product.vo.AdminProductListVO;
import com.thisisthat.admin.product.vo.AdminProductVO;

public interface AdminProductService {

	void insertProduct(AdminProductVO vo,List<AdminProductImageVO> imageList);
	List<AdminCategoryVO> getCategoryList();
	List<AdminProductListVO> getProductList();
	AdminProductVO getProduct(long productNo);
	List<AdminProductImageVO> getProductImage(long productNo);
	long getProductStock(long productNo);
	void deleteProduct(long productNo);
	void updateProduct(AdminProductVO vo);
	void updateMainImage(AdminProductImageVO vo);
	void deleteSubImage(long productNo);
	void insertSubImage(AdminProductImageVO vo);
}
