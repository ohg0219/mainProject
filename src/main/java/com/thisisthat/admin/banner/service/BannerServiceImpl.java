package com.thisisthat.admin.banner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.banner.dao.BannerDAO;
import com.thisisthat.admin.banner.vo.BannerVO;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	BannerDAO dao;
	
	@Override
	public List<BannerVO> getBannerList() {
		return dao.getBannerList();
	}

	@Override
	public void insertBanner(BannerVO banner) {
		dao.insertBanner(banner);

	}

	@Override
	public void updateOrder(List<BannerVO> bannerList) {
		dao.updateOrder(bannerList);
		
	}

	@Override
	public void deleteBanner(int bannerOrder) {
		dao.deleteBanner(bannerOrder);
		
	}

}
