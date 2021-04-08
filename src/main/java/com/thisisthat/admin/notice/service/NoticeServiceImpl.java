package com.thisisthat.admin.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.notice.dao.NoticeDAO;
import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.notice.vo.SearchVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

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
	public List<NoticeVO> noticeList(PagingVO vo, SearchVO search, NoticeVO noticeVO) {
		 return noticeDAO.noticeList(vo, search, noticeVO);
	}

	@Override
	public String nickname(NoticeVO noticeVO) {
		return noticeDAO.nickname(noticeVO);
	}

	@Override
	public int totalCount(SearchVO search, NoticeVO noticeVO) {
		return noticeDAO.totalCount(search, noticeVO);
	}
	
}
