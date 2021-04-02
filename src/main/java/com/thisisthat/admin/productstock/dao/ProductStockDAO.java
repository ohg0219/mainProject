package com.thisisthat.admin.productstock.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.productstock.vo.ProductStockVO;

@Repository
public class ProductStockDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<ProductStockVO> getStockList(ProductStockVO productStockVO) {
		
		return mybatis.selectList("Product_StockDAO.getStockList", productStockVO);
	}

	public ProductStockVO getProductStock(ProductStockVO productStockVO) {

		return mybatis.selectOne("Product_StockDAO.getProductStock", productStockVO);
	}

	public void updateStock(ProductStockVO productStockVO) {
		mybatis.update("Product_StockDAO.updateStock", productStockVO);
		
	}

	public List<ProductStockVO> getProductStockList(ProductStockVO productStockVO) {
		return mybatis.selectList("Product_StockDAO.getProductStockList", productStockVO);
	}

	public List<ProductStockVO> allList(ProductStockVO productStockVO) {
		return mybatis.selectList("Product_StockDAO.allList", productStockVO);
	}

	public List<ProductStockVO> productnoList(ProductStockVO productStockVO) {
		return mybatis.selectList("Product_StockDAO.productnoList", productStockVO);
	}

	public List<ProductStockVO> productnameList(ProductStockVO productStockVO) {
		return mybatis.selectList("Product_StockDAO.productnameList", productStockVO);
	}

	
	
	
}
