package com.thisisthat.admin.main.service;

import java.util.Date;
import java.util.List;

import com.thisisthat.admin.main.vo.AdminDailyCategoryVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

public interface AdminService {
	UserVO idCheck(String userId);
	long getThisMonthSales();
	long getThisDaySales();
	int noAnswerCount();
	List<String> getOneWeekSales(List<Date> dateList); 
	List<AdminDailyCategoryVO> getTodayCatgorySales();
	boolean userCheck(UserVO user);
	void updateUser(UserVO user);
}	
