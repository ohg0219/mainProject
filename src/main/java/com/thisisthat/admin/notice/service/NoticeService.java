package com.thisisthat.admin.notice.service;

import java.util.List;

import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

public interface NoticeService {
	
	void insertNotice(NoticeVO noticeVO);
	
	void updateNotice(NoticeVO noticeVO);
	
	void deleteNotice(NoticeVO noticeVO);
	
	NoticeVO notice(NoticeVO noticeVO);
	
	List<NoticeVO> noticeList(NoticeVO noticeVO);

	List<NoticeVO> allNotice(NoticeVO noticeVO);
	
	List<NoticeVO> titleNotice(NoticeVO noticeVO);
	
	List<NoticeVO> writerNotice(NoticeVO noticeVO);
	
	List<NoticeVO> contentNotice(NoticeVO noticeVO);

	String nickname(NoticeVO noticeVO);
	
}


