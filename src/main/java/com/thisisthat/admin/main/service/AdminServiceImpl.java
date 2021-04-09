package com.thisisthat.admin.main.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.main.dao.AdminDAO;
import com.thisisthat.admin.main.vo.AdminDailyCategoryVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDAO dao;
	
	@Override
	public UserVO idCheck(String userId) {
		return dao.idCheck(userId);
	}

	@Override
	public long getThisMonthSales() {
		return dao.getThisMonthSales();
	}

	@Override
	public long getThisDaySales() {
		return dao.getThisDaySales();
	}

	@Override
	public int noAnswerCount() {
		return dao.noAnswerCount();
	}

	@Override
	public List<String> getOneWeekSales(List<Date> dateList) {
		return dao.getOneWeekSales(dateList);
	}

	@Override
	public List<AdminDailyCategoryVO> getTodayCatgorySales() {
		return dao.getTodayCatgorySales();
	}

	@Override
	public boolean userCheck(UserVO user) {
		// TODO Auto-generated method stub
		return dao.userCheck(user);
	}

	@Override
	public void updateUser(UserVO user) {
		dao.updateUser(user);
		
	}



}
