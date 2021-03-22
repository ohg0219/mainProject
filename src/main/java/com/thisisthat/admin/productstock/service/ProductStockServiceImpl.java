package com.thisisthat.admin.productstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.productstock.dao.ProductStockDAO;
import com.thisisthat.admin.productstock.vo.ProductStockVO;

@Service("ProductStockService")
public class ProductStockServiceImpl implements ProductStockService {
	@Autowired
	private ProductStockDAO product_StockDAO;

	@Override
	public List<ProductStockVO> stockList(ProductStockVO productStockVO) {
		
		return product_StockDAO.getProductStockList(productStockVO);
	}

	@Override
	public ProductStockVO getStock(ProductStockVO productStockVO) {
		
		return product_StockDAO.getProductStock(productStockVO);
	}
	
	
}
