package com.thisisthat.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.log.dao.LogDAO;
import com.thisisthat.log.vo.LogVO;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	LogDAO logDAO;
	
	@Override
	public void insertLog(LogVO log) {
		
		logDAO.insertLog(log);
	}

}
