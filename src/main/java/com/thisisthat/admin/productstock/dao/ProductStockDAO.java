package com.thisisthat.admin.productstock.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.productstock.vo.ProductStockVO;
import com.thisisthat.util.PagingVO;

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

	public List<ProductStockVO> getProductStockList(ProductStockVO productStockVO, PagingVO paging) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_category", productStockVO.getProduct_category());
		map.put("start", paging.getStart());
		map.put("cntPerPage", paging.getCntPerPage());
		
		return mybatis.selectList("Product_StockDAO.getProductStockList", map);
	}
	public int getCount(ProductStockVO productStockVO) {
		return mybatis.selectOne("Product_StockDAO.getCount",productStockVO);
	}

	
	
	
}
