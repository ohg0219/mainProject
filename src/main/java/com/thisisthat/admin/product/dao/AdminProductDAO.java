package com.thisisthat.admin.product.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thisisthat.admin.category.vo.AdminCategoryVO;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.admin.product.vo.AdminProductListVO;
import com.thisisthat.admin.product.vo.AdminProductSizeGuideVO;
import com.thisisthat.admin.product.vo.AdminProductSizeUsedVO;
import com.thisisthat.admin.product.vo.AdminProductVO;
import com.thisisthat.util.PagingVO;

@Repository
public class AdminProductDAO {

	@Autowired
	private SqlSessionTemplate productTemplate;
	
	@Transactional
	public void insertProduct(AdminProductVO vo,List<AdminProductImageVO> imageList,List<AdminProductSizeGuideVO> sizeGuideList,AdminProductSizeUsedVO sizeVO) {
		productTemplate.insert("AdminProduct.insertProduct",vo);
		int result = productTemplate.selectOne("AdminProduct.getSeq");
		for(AdminProductImageVO image : imageList) {
			image.setProduct_no(result);
			productTemplate.insert("AdminProduct.insertProductImage",image);
		}
		productTemplate.insert("AdminProduct.insertProductStock",result);
		for(AdminProductSizeGuideVO size : sizeGuideList) {
			size.setProduct_no(result);
			productTemplate.insert("AdminProduct.insertSizeGuide",size);
		}
		sizeVO.setProduct_no(result);
		productTemplate.insert("AdminProduct.insertSizeUsed",sizeVO);
	}
	
	public List<AdminCategoryVO> getCategoryList(){
		return productTemplate.selectList("AdminProduct.getCategoryList");
	}
	
	public List<AdminProductListVO> getProductList(PagingVO pagingVO,AdminProductVO vo){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("used", String.valueOf(vo.getProduct_used()));
		map.put("searchKeyword", vo.getSearchKeyword());
		map.put("category", vo.getProduct_category());
		map.put("cntPerPage",pagingVO.getCntPerPage());
		map.put("start", pagingVO.getStart());
		return productTemplate.selectList("AdminProduct.getProductList",map);
	}
	
	public AdminProductVO getProduct(long productNo) {
		return (AdminProductVO) productTemplate.selectOne("AdminProduct.getProduct",productNo);
	}
	
	public List<AdminProductImageVO> getProductImage(long productNo){
		return productTemplate.selectList("AdminProduct.getProductImage",productNo);
	}
	
	public long getProductStock(long productNo) {
		return productTemplate.selectOne("AdminProduct.getProductStock",productNo);
	} 
	
	public List<AdminProductSizeGuideVO> getProductSizeGuide(long productNo) {
		return productTemplate.selectList("AdminProduct.getProductSizeGuide",productNo);
	}
	public AdminProductSizeUsedVO getProductSizeUsed(long productNo) {
		return productTemplate.selectOne("AdminProduct.getProductSizeUsed",productNo);
	}
	
	
	@Transactional
	public void deleteProduct(long productNo) {
		productTemplate.delete("AdminProduct.deleteProduct",productNo);
		productTemplate.delete("AdminProduct.deleteProductImage",productNo);
		productTemplate.delete("AdminProduct.deleteProductStock",productNo);
		productTemplate.delete("AdminProduct.deleteProductSizeGuide",productNo);
		productTemplate.delete("AdminProduct.deleteProductSizeUsed",productNo);
	}
	
	public void updateProduct(AdminProductVO vo) {
		productTemplate.update("AdminProduct.updateProduct",vo);
	}
	
	public void updateMainImage(AdminProductImageVO vo) {
		productTemplate.update("AdminProduct.updateMainImage",vo);
	}
	
	public void deleteSubImage(long productNo) {
		productTemplate.delete("AdminProduct.deleteSubImage",productNo);
	}
	
	public void insertSubImage(AdminProductImageVO vo) {
		productTemplate.insert("AdminProduct.insertSubImage",vo);
	}

	public void updateProductSizeGuide(List<AdminProductSizeGuideVO> sizeGuideList) {
		for(AdminProductSizeGuideVO size : sizeGuideList) {
			productTemplate.update("AdminProduct.updateProductSizeGuide",size);
		}
	}
	
	public void updateProductSizeUsed(AdminProductSizeUsedVO sizeVO) {
		productTemplate.update("AdminProduct.updateProductSizeUsed",sizeVO);
	}
	
	
	
	public int getProductCount(AdminProductVO vo) {
		return productTemplate.selectOne("AdminProduct.getProductCount",vo);
	}
	
}
