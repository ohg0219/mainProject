package com.thisisthat.user.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSessionTemplate userTemplate;
	
	public List<BannerVO> getBannerList(){
		return userTemplate.selectList("bannerDAO.getBannerList");
	}
	
	public UtilizationVO getUtilization() {
		return userTemplate.selectOne("termsDAO.getTopUtilization");
	}
	
	public InformationVO getPrivacy() {
		return userTemplate.selectOne("termsDAO.getTopInformation");
	}
}
