package com.thisisthat.admin.terms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.terms.dao.TermsDAO;
import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.util.PagingVO;

@Service
public class TermsServiceImpl implements TermsService {

	@Autowired
	TermsDAO termsDAO;
	
	@Override
	public void insertUtilization(UtilizationVO util) {
		termsDAO.insertUtilization(util);

	}

	@Override
	public void insertInformation(InformationVO info) {
		termsDAO.insertInformation(info);

	}

	@Override
	public List<UtilizationVO> getUtilizationList(PagingVO paging) {
		return termsDAO.getUtilizationList(paging);
	}

	@Override
	public List<InformationVO> getInformationList(PagingVO paging) {
		return termsDAO.getInformationList(paging);
	}

	@Override
	public int getUtilizationTotal() {
		return termsDAO.getUtilizationTotal();
	}

	@Override
	public int getInformationTotal() {
		return termsDAO.getInformationTotal();
	}

	@Override
	public UtilizationVO getUtilization(int no) {
		
		return termsDAO.getUtilization(no);
	}

	@Override
	public InformationVO getInformation(int no) {
		return termsDAO.getInformation(no);
	}

}
