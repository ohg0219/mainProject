package com.thisisthat.admin.notice.service;

import java.util.List;

import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.notice.vo.SearchVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

public interface NoticeService {
	
	void insertNotice(NoticeVO noticeVO);
	
	void updateNotice(NoticeVO noticeVO);
	
	void deleteNotice(NoticeVO noticeVO);
	
	NoticeVO notice(NoticeVO noticeVO);
	
	List<NoticeVO> noticeList(PagingVO vo, SearchVO search, NoticeVO noticeVO);

	String nickname(NoticeVO noticeVO);

	int totalCount(SearchVO search, NoticeVO noticeVO);
	
}


