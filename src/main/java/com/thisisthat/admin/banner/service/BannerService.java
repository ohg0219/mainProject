package com.thisisthat.admin.banner.service;

import java.util.List;

import com.thisisthat.admin.banner.vo.BannerVO;

public interface BannerService {
	List<BannerVO> getBannerList();
	void insertBanner(BannerVO banner);
	void updateOrder(List<BannerVO> bannerList);
	void deleteBanner(int bannerOrder);
}
