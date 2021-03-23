package com.thisisthat.user.email.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.email.dao.EmailDAO;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	EmailDAO dao;
	
	@Override
	public List<String> getIdEmail(Map<String, Object> map) {
		return dao.getIdEmail(map);
	}
	
	@Override
	public String getPwEmail(Map<String, Object> map) {
		return dao.getPwEmail(map);
	}

	@Override
	public void updatePw(Map<String, Object> map) {
		dao.updatePw(map);
	}
	
	
	
	
}