package com.thisisthat.user.phone.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.phone.dao.PhoneDAO;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
	private PhoneDAO dao;
	
	@Override
	public List<String> IdPhone(Map<String, Object> map) {
		return dao.findIdPhone(map);
	}

	@Override
	public String PwPhone(Map<String, Object> map) {
		return dao.findPwPhone(map);
	}
	
	@Override
	public void PwUpdate(Map<String, Object> map) {
		dao.updatePw(map);
	}
	
}
