package com.thisisthat.admin.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.category.dao.AdminCategoryDAO;
import com.thisisthat.admin.category.vo.AdminCategoryVO;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

	@Autowired
	private AdminCategoryDAO categoryDAO;
	
	@Override
	public List<AdminCategoryVO> getCategoryList() {
		return categoryDAO.getCategoryList();
	}

	@Override
	public AdminCategoryVO getCategory(int categorySeq) {
		return categoryDAO.getCategory(categorySeq);
	}

	@Override
	public void insertCategory(AdminCategoryVO vo) {
		categoryDAO.insertCategory(vo);
	}

	@Override
	public void updateCategory(AdminCategoryVO vo) {
		categoryDAO.updateCategory(vo);
		
	}

	@Override
	public void deleteCategory(int categorySeq) {
		categoryDAO.deleteCategory(categorySeq);
	}


}
