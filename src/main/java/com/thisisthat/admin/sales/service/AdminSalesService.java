package com.thisisthat.admin.sales.service;

import java.util.Date;
import java.util.List;

import com.thisisthat.admin.sales.vo.AdminSalesDataVO;

public interface AdminSalesService {

	List<AdminSalesDataVO> getMontlySales(Date startMonth,Date endMonth);
	List<AdminSalesDataVO> getDailySales(Date startDay,Date endDay);
	List<AdminSalesDataVO> getCategorySales(Date startDay,Date endDay);
	List<AdminSalesDataVO> getDatelySales(Date startDay,Date endDay);
}
