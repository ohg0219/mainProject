package com.thisisthat.admin.sales.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.sales.vo.AdminSalesDataVO;

@Repository
public class AdminSalesDAO {

	@Autowired
	SqlSessionTemplate salesTemplate;
	
	public List<AdminSalesDataVO> getMontlySales(Date startMonth,Date endMonth){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startMonth", startMonth);
		map.put("endMonth", endMonth);
		return salesTemplate.selectList("AdminSalesDAO.getMontlySales",map);
	}
	
	public List<AdminSalesDataVO> getDailySales(Date startDay,Date endDay){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startDay", startDay);
		map.put("endDay", endDay);
		return salesTemplate.selectList("AdminSalesDAO.getDailySales",map);
	}
	
	public List<AdminSalesDataVO> getCategorySales(Date startDay,Date endDay){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startDay", startDay);
		map.put("endDay", endDay);
		return salesTemplate.selectList("AdminSalesDAO.getCategorySales",map);
	}

	public List<AdminSalesDataVO> getDatelySales(Date startDay,Date endDay){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startDay", startDay);
		map.put("endDay", endDay);
		return salesTemplate.selectList("AdminSalesDAO.getDatelySales",map);
	}
	
	
}
