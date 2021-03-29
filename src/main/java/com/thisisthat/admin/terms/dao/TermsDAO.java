package com.thisisthat.admin.terms.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.util.PagingVO;

@Repository
public class TermsDAO {
	
	@Autowired
	SqlSessionTemplate termsTemplate;
	
	public void insertUtilization(UtilizationVO util) {
		termsTemplate.insert("termsDAO.insertUtilization",util);

	}

	public void insertInformation(InformationVO info) {
		termsTemplate.insert("termsDAO.insertInformation",info);

	}
	
	public int getUtilizationTotal() {
		return termsTemplate.selectOne("termsDAO.getUtilizationTotal");
	}
	public int getInformationTotal() {
		return termsTemplate.selectOne("termsDAO.getInformationTotal");
	}
	
	public List<UtilizationVO> getUtilizationList(PagingVO paging) {
		return termsTemplate.selectList("termsDAO.getUtilizationList",paging);
	}

	public List<InformationVO> getInformationList(PagingVO paging) {
		return termsTemplate.selectList("termsDAO.getInformationList",paging);
	}
	
	public UtilizationVO getUtilization(int no) {
		
		return termsTemplate.selectOne("termsDAO.getUtilization",no);
	}

	public InformationVO getInformation(int no) {
		return termsTemplate.selectOne("termsDAO.getInformation",no);

	}
	
}
