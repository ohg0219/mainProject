package com.thisisthat.admin.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.category.vo.AdminCategoryVO;
import com.thisisthat.admin.product.dao.AdminProductDAO;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.admin.product.vo.AdminProductListVO;
import com.thisisthat.admin.product.vo.AdminProductSizeUsedVO;
import com.thisisthat.admin.product.vo.AdminProductSizeGuideVO;
import com.thisisthat.admin.product.vo.AdminProductVO;
import com.thisisthat.util.PagingVO;

@Service
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	private AdminProductDAO productDAO;
	
	@Override
	public void insertProduct(AdminProductVO vo, List<AdminProductImageVO> imageList,List<AdminProductSizeGuideVO> sizeGuideList,AdminProductSizeUsedVO sizeVO) {
		productDAO.insertProduct(vo, imageList, sizeGuideList, sizeVO);
	}

	@Override
	public List<AdminCategoryVO> getCategoryList() {
		return productDAO.getCategoryList();
	}

	@Override
	public List<AdminProductListVO> getProductList(PagingVO pagingVO,AdminProductVO vo) {
		return productDAO.getProductList(pagingVO,vo);
	}

	@Override
	public AdminProductVO getProduct(long productNo) {
		return productDAO.getProduct(productNo);
	}

	@Override
	public List<AdminProductImageVO> getProductImage(long productNo) {
		return productDAO.getProductImage(productNo);
	}

	@Override
	public long getProductStock(long productNo) {
		return productDAO.getProductStock(productNo);
	}

	@Override
	public void deleteProduct(long productNo) {
		productDAO.deleteProduct(productNo);
	}

	@Override
	public void updateProduct(AdminProductVO vo) {
		productDAO.updateProduct(vo);
	}

	@Override
	public void updateMainImage(AdminProductImageVO vo) {
		productDAO.updateMainImage(vo);
	}

	@Override
	public void deleteSubImage(long productNo) {
		productDAO.deleteSubImage(productNo);
	}

	@Override
	public void insertSubImage(AdminProductImageVO vo) {
		productDAO.insertSubImage(vo);
	}

	@Override
	public int getProductCount(AdminProductVO vo) {
		return productDAO.getProductCount(vo);
	}

	@Override
	public List<AdminProductSizeGuideVO> getProductSizeGuide(long productNo) {
		return productDAO.getProductSizeGuide(productNo);
	}

	@Override
	public AdminProductSizeUsedVO getProductSizeUsed(long productNo) {
		return productDAO.getProductSizeUsed(productNo);
	}

	@Override
	public void updateProductSizeGuide(AdminProductVO vo,List<AdminProductSizeGuideVO> sizeGuideList) {
		productDAO.updateProductSizeGuide(vo,sizeGuideList);
	}

	@Override
	public void updateProductSizeUsed(AdminProductSizeUsedVO sizeVO) {
		productDAO.updateProductSizeUsed(sizeVO);
	}

	
	
	

	
	
}
