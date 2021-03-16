package com.thisisthat.admin.product.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thisisthat.admin.category.vo.AdminCategoryVO;
import com.thisisthat.admin.product.vo.AdminProductImageVO;
import com.thisisthat.admin.product.vo.AdminProductListVO;
import com.thisisthat.admin.product.vo.AdminProductVO;

@Repository
public class AdminProductDAO {

	@Autowired
	private SqlSessionTemplate productTemplate;
	
	@Transactional
	public void insertProduct(AdminProductVO vo,List<AdminProductImageVO> imageList) {
		productTemplate.insert("AdminProduct.insertProduct",vo);
		int result = productTemplate.selectOne("AdminProduct.getSeq");
		for(AdminProductImageVO image : imageList) {
			image.setProduct_no(result);
			productTemplate.insert("AdminProduct.insertProductImage",image);
		}
		productTemplate.insert("AdminProduct.insertProductStock",result);
	}
	
	public List<AdminCategoryVO> getCategoryList(){
		return productTemplate.selectList("AdminProduct.getCategoryList");
	}
	
	public List<AdminProductListVO> getProductList(){
		return productTemplate.selectList("AdminProduct.getProductList");
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
	
	@Transactional
	public void deleteProduct(long productNo) {
		productTemplate.delete("AdminProduct.deleteProduct",productNo);
		productTemplate.delete("AdminProduct.deleteProductImage",productNo);
		productTemplate.delete("AdminProduct.deleteProductStock",productNo);
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
	
}
