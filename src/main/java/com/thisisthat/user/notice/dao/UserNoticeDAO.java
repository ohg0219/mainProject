package com.thisisthat.user.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.thisisthat.user.notice.vo.UserNoticeVO;

@Repository
public class UserNoticeDAO {
	@Autowired
	SqlSessionTemplate userNoticeTemplate;
	
	public UserNoticeVO getNotice(UserNoticeVO vo) {
		return (UserNoticeVO) userNoticeTemplate.selectOne("UserNoticeM.getNotice", vo);
	}
	
	public UserNoticeVO getEvent(UserNoticeVO vo) {
		return (UserNoticeVO) userNoticeTemplate.selectOne("UserNoticeM.getEvent", vo);
	}
	
	public List<UserNoticeVO> getNoticeList(UserNoticeVO vo){
		return userNoticeTemplate.selectList("UserNoticeM.getNoticeList", vo);
	}
	
	public List<UserNoticeVO> getEventList(UserNoticeVO vo){
		return userNoticeTemplate.selectList("UserNoticeM.getEventList", vo);
	}
	
	public void plusCnt(int board_no) {
		userNoticeTemplate.update("UserNoticeM.plusCnt", board_no);
	}
}
