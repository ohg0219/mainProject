package com.thisisthat.admin.grant.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.thisisthat.admin.grant.coupon.service.CouponGrantService;

@Controller
public class GrantCouponController {

	@Autowired
	private CouponGrantService couponGrantService;
	
	
}
