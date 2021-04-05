package com.thisisthat.admin.sales.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.sales.dao.AdminSalesDAO;
import com.thisisthat.admin.sales.vo.AdminSalesDataVO;

@Service
public class AdminSalesServiceImpl implements AdminSalesService {

	@Autowired
	private AdminSalesDAO salesDAO;
	
	@Override
	public List<AdminSalesDataVO> getMontlySales(Date startMonth, Date endMonth) {
		return salesDAO.getMontlySales(startMonth, endMonth);
	}

	@Override
	public List<AdminSalesDataVO> getDailySales(Date startDay,Date endDay) {
		return salesDAO.getDailySales(startDay, endDay);
	}

	@Override
	public List<AdminSalesDataVO> getCategorySales(Date startDay, Date endDay) {
		return salesDAO.getCategorySales(startDay, endDay);
	}

	@Override
	public List<AdminSalesDataVO> getDatelySales(Date startDay, Date endDay) {
		return salesDAO.getDatelySales(startDay, endDay);
	}

}
