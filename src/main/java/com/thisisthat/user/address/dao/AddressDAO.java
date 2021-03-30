package com.thisisthat.user.address.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.address.vo.AddressVO;

@Repository
public class AddressDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<AddressVO> addressList(AddressVO vo) {
		return mybatis.selectList("AddressDAO.addressList", vo);
	}
	
	public void addressInsert(AddressVO vo) {
		mybatis.insert("AddressDAO.addressInsert", vo);
	}
	
	public AddressVO getaddress(AddressVO vo) {
		return mybatis.selectOne("AddressDAO.getAddress", vo);
	}
	
	public void addressUpdate(AddressVO vo) {
		mybatis.update("AddressDAO.addressUpdate", vo);
	}
	
	public void addressDelete(int addressNo) {
		mybatis.delete("AddressDAO.addressDelete", addressNo);
	}

}
