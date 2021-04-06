package com.thisisthat.log.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.log.vo.LogVO;

@Repository
public class LogDAO {
	@Autowired
	SqlSessionTemplate logTemplate;

	public void insertLog(LogVO log) {

		logTemplate.insert("logDAO.insertLog",log);
	}
}
