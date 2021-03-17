package com.thisisthat.admin.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.notice.dao.NoticeDAO;
import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public void insertNotice(NoticeVO noticeVO) {
		noticeDAO.insertNotice(noticeVO);
	}

	@Override
	public void updateNotice(NoticeVO noticeVO) {
		 noticeDAO.updateNotice(noticeVO);		
	}

	@Override
	public void deleteNotice(NoticeVO noticeVO) {
		 noticeDAO.deleteNotice(noticeVO);
		
	}

	@Override
	public NoticeVO notice(NoticeVO noticeVO) {
		return noticeDAO.notice(noticeVO);
	}

	@Override
	public List<NoticeVO> noticeList(NoticeVO noticeVO) {
		 return noticeDAO.noticeList(noticeVO);
	}

	@Override
	public List<NoticeVO> allNotice(NoticeVO noticeVO) {
		return noticeDAO.allNotice(noticeVO);
	}

	@Override
	public List<NoticeVO> titleNotice(NoticeVO noticeVO) {
		return noticeDAO.titleNotice(noticeVO);
	}

	@Override
	public List<NoticeVO> writerNotice(NoticeVO noticeVO) {
		return noticeDAO.writerNotice(noticeVO);
	}

	@Override
	public List<NoticeVO> contentNotice(NoticeVO noticeVO) {
		return noticeDAO.contentNotice(noticeVO);
	}

	@Override
	public String nickname(NoticeVO noticeVO) {
		return noticeDAO.nickname(noticeVO);
	}
	
}
