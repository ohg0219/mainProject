package com.thisisthat.user.service;

import java.util.List;

import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;

public interface UserService {
	List<BannerVO>getBannerList(String state);
	UtilizationVO getUtilization();
	InformationVO getPrivacy();
}
