package com.thisisthat.admin.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.category.vo.AdminCategoryVO;
import com.thisisthat.admin.product.dao.AdminProductDAO;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.admin.product.vo.AdminProductListVO;
import com.thisisthat.admin.product.vo.AdminProductVO;

@Service
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	private AdminProductDAO productDAO;
	
	@Override
	public void insertProduct(AdminProductVO vo, List<AdminProductImageVO> imageList) {
		productDAO.insertProduct(vo, imageList);
	}

	@Override
	public List<AdminCategoryVO> getCategoryList() {
		return productDAO.getCategoryList();
	}

	@Override
	public List<AdminProductListVO> getProductList() {
		return productDAO.getProductList();
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

	
	

	
	
}
