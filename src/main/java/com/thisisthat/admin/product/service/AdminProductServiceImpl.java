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

	

	
	
}
