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
		List<AdminSalesDataVO> sales = salesTemplate.selectList("AdminSalesDAO.getMontlySales",map);
		List<AdminSalesDataVO> salesCount = salesTemplate.selectList("AdminSalesDAO.getMonthlySalesCount",map);
		for(int i = 0; i<sales.size();i++) {
			for(int j =0;j<salesCount.size();j++) {
				if(sales.get(i).getGrouping().compareTo(salesCount.get(j).getGrouping())==0) {
					sales.get(i).setCount(salesCount.get(j).getCount());
				}
			}
		}
		return sales;
	}
	
	public List<AdminSalesDataVO> getDailySales(Date startDay,Date endDay){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startDay", startDay);
		map.put("endDay", endDay);
		List<AdminSalesDataVO> sales = salesTemplate.selectList("AdminSalesDAO.getDailySales",map);
		List<AdminSalesDataVO> salesCount = salesTemplate.selectList("AdminSalesDAO.getDailySalesCount",map);
		for(int i = 0; i<sales.size();i++) {
			for(int j =0;j<salesCount.size();j++) {
				if(sales.get(i).getGrouping().compareTo(salesCount.get(j).getGrouping())==0) {
					sales.get(i).setCount(salesCount.get(j).getCount());
				}
			}
		}
		return sales;
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
		List<AdminSalesDataVO> sales = salesTemplate.selectList("AdminSalesDAO.getDatelySales",map);
		List<AdminSalesDataVO> salesCount = salesTemplate.selectList("AdminSalesDAO.getDatelySalesCount",map);
		for(int i = 0; i<sales.size();i++) {
			for(int j =0;j<salesCount.size();j++) {
				if(sales.get(i).getGroupString().equals(salesCount.get(j).getGroupString())) {
					sales.get(i).setCount(salesCount.get(j).getCount());
				}
			}
		}
		return sales;
	}
	
	
}
