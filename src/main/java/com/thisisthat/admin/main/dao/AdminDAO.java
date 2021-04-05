package com.thisisthat.admin.main.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.main.vo.AdminDailyCategoryVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Repository
public class AdminDAO {
	@Autowired
	private SqlSessionTemplate adminTemplate;
	
	public UserVO idCheck(String userId) {
		return adminTemplate.selectOne("AdminDAO.getUser" , userId);
	}

	public long getThisMonthSales() {
		return adminTemplate.selectOne("AdminDAO.getThisMonthSales");
	}
	
	public long getThisDaySales() {
		return adminTemplate.selectOne("AdminDAO.getThisDaySales");
	}

	public int noAnswerCount() {
		return adminTemplate.selectOne("AdminDAO.noAnswerCount");
	}
	
	public List<String> getOneWeekSales(List<Date> dateList){
		List<String> dataList = new ArrayList<String>();
		for(Date date : dateList) {
			dataList.add(adminTemplate.selectOne("AdminDAO.getOneWeekSales",date));
		}
		return dataList;
	}
	
	public List<AdminDailyCategoryVO> getTodayCatgorySales(){
		return adminTemplate.selectList("AdminDAO.getTodayCatgorySales");
	}
	
}
