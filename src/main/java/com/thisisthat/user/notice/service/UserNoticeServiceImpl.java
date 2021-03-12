package com.thisisthat.user.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.notice.dao.UserNoticeDAO;
import com.thisisthat.user.notice.vo.UserNoticeVO;

@Service
public class UserNoticeServiceImpl implements UserNoticeService{
	
	@Autowired
	private UserNoticeDAO userNoticeDAO;
	
	public UserNoticeVO getNotice(UserNoticeVO vo) {
		return userNoticeDAO.getNotice(vo);
	}
	@Override
	public UserNoticeVO getEvent(UserNoticeVO vo) {
		return userNoticeDAO.getEvent(vo);
	}

	@Override
	public List<UserNoticeVO> getNoticeList(UserNoticeVO vo) {
		return userNoticeDAO.getNoticeList(vo);
	}

	@Override
	public List<UserNoticeVO> getEventList(UserNoticeVO vo) {
		return userNoticeDAO.getEventList(vo);
	}
	@Override
	public void plusCnt(int board_no) {
		userNoticeDAO.plusCnt(board_no);
	}


}
