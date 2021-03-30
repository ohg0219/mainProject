package com.thisisthat.user.address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.address.dao.AddressDAO;
import com.thisisthat.user.address.vo.AddressVO;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO dao;
	
	@Override
	public List<AddressVO> getAddressList(AddressVO vo) {
		return dao.addressList(vo);
	}
	
	@Override
	public void addressInsert(AddressVO vo) {
		dao.addressInsert(vo);
	}
	
	@Override
	public AddressVO getAddress(AddressVO vo) {
		return dao.getaddress(vo);
	}
	
	@Override
	public void addressUpdate(AddressVO vo) {
		dao.addressUpdate(vo);
	}
	
	@Override
	public void addressDelete(int addressNo) {
		dao.addressDelete(addressNo);
	}
	
	
}
