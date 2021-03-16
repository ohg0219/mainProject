package com.thisisthat.admin.category.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.category.vo.AdminCategoryVO;

@Repository
public class AdminCategoryDAO {

	@Autowired
	private SqlSessionTemplate categoryTemplate;
	
	public List<AdminCategoryVO> getCategoryList(){
		return categoryTemplate.selectList("AdminCategory.getCategoryList");
	}
	
	public AdminCategoryVO getCategory(int categorySeq) {
		return categoryTemplate.selectOne("AdminCategory.getCategory",categorySeq);
	}
	
	public void insertCategory(AdminCategoryVO vo) {
		categoryTemplate.insert("AdminCategory.insertCategory",vo);
	}
	
	public void updateCategory(AdminCategoryVO vo) {
		categoryTemplate.update("AdminCategory.updateCategory",vo);
	}
	
	public void deleteCategory(int categorySeq) {
		categoryTemplate.delete("AdminCategory.deleteCategory",categorySeq);
	}
	
}
