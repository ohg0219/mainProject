package com.thisisthat.admin.terms.service;

import java.util.List;

import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

public interface TermsService {
	void insertUtilization(UtilizationVO util);
	void insertInformation(InformationVO info);
	List<UtilizationVO> getUtilizationList(PagingVO paging);
	List<InformationVO> getInformationList(PagingVO paging);
	int getUtilizationTotal();
	int getInformationTotal();
	UtilizationVO getUtilization(int no);
	InformationVO getInformation(int no);
	List<UserVO>  getUserList();
}
