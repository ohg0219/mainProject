package com.thisisthat.user.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.notice.dao.UserNoticeDAO;
import com.thisisthat.user.notice.vo.UserNoticeVO;
import com.thisisthat.util.PagingVO;

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
	
	/*
	@Override
	public List<UserNoticeVO> allNotice(UserNoticeVO vo) {
		return userNoticeDAO.allNotice(vo);
	}
	@Override
	public List<UserNoticeVO> titleNotice(UserNoticeVO vo) {
		return userNoticeDAO.titleNotice(vo);
	}
	@Override
	public List<UserNoticeVO> writerNotice(UserNoticeVO vo) {
		return userNoticeDAO.writerNotice(vo);
	}
	@Override
	public List<UserNoticeVO> contentNotice(UserNoticeVO vo) {
		return userNoticeDAO.contentNotice(vo);
	}
	*/
	@Override
	public int noticeCount(String searchOption, String keyword,String group) {
		return userNoticeDAO.noticeCount(searchOption, keyword, group);
	}
	
	@Override
	public List<UserNoticeVO> noticeList(PagingVO paging, String searchOption, String keyword) {
		return userNoticeDAO.noticeList(paging, searchOption, keyword);
	}
	
	@Override
	public List<UserNoticeVO> eventList(PagingVO paging, String searchOption, String keyword) {
		return userNoticeDAO.eventList(paging, searchOption, keyword);
	}
	
	
}
