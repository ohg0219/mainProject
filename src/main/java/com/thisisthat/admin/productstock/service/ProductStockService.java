package com.thisisthat.admin.productstock.service;

import java.util.List;

import com.thisisthat.admin.productstock.vo.ProductStockVO;
import com.thisisthat.util.PagingVO;

public interface ProductStockService {
	
	int getCount(ProductStockVO productStockVO,String searchOption);
	
	List<ProductStockVO> stockList(ProductStockVO productStockVO);

	ProductStockVO getStock(ProductStockVO productStockVO);

	void updateStock(ProductStockVO productStockVO);

	List<ProductStockVO> poductStockList(ProductStockVO productStockVO,String searchOption, PagingVO paging);

	List<ProductStockVO> allList(ProductStockVO productStockVO);

	List<ProductStockVO> productnoList(ProductStockVO productStockVO);

	List<ProductStockVO> productnameList(ProductStockVO productStockVO);

	ProductStockVO sizepro(ProductStockVO productStockVO);

}
