package com.thisisthat.user.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryMenuServiceImpl implements CategoryMenuService {

	@Autowired
	private CategoryMenuDAO dao;

	@Override
	public List<String> getCategoryList() {
		return dao.getCategoryList();
	}
	
}
