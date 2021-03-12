package com.thisisthat.admin.category.service;

import java.util.List;

import com.thisisthat.admin.category.vo.AdminCategoryVO;

public interface AdminCategoryService {

	List<AdminCategoryVO> getCategoryList();
	AdminCategoryVO getCategory(int categorySeq);
	void insertCategory(AdminCategoryVO vo);
	void updateCategory(AdminCategoryVO vo);
	void deleteCategory(int categorySeq);
}
