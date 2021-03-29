package com.thisisthat.admin.banner.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.banner.vo.BannerVO;
@Repository
public class BannerDAO {
	
	@Autowired
	SqlSessionTemplate bannerTemplate;
	
	public List<BannerVO> getBannerList() {
		
		return bannerTemplate.selectList("bannerDAO.getBannerList");
	}

	public void insertBanner(BannerVO banner) {
		Integer order = bannerTemplate.selectOne("bannerDAO.getMaxBannerOrder");
		
		if(order == null) order = 0;
		banner.setBannerOrder(order + 1);
		
		bannerTemplate.selectOne("bannerDAO.insertBanner",banner);

	}
	public void updateOrder(List<BannerVO> bannerList) {
		for(BannerVO banner : bannerList) {
			bannerTemplate.selectOne("bannerDAO.updateOrder", banner);
		}
	}
	public void deleteBanner(int bannerOrder) {
		bannerTemplate.selectOne("bannerDAO.deleteBanner", bannerOrder);
		
	}
}
