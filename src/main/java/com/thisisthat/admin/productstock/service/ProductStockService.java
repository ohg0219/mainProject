package com.thisisthat.admin.productstock.service;

import java.util.List;

import com.thisisthat.admin.productstock.vo.ProductStockVO;

public interface ProductStockService {

	List<ProductStockVO> stockList(ProductStockVO productStockVO);

}
