package com.thisisthat.user.address.service;

import java.util.List;

import com.thisisthat.user.address.vo.AddressVO;

public interface AddressService {

	List<AddressVO> getAddressList(AddressVO vo);

	void addressInsert(AddressVO vo);

	AddressVO getAddress(AddressVO vo);

	void addressUpdate(AddressVO vo);
	
	void addressDelete(int addressNo);

}