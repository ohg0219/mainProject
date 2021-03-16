package com.thisisthat.user.notice.service;

import java.util.List;

import com.thisisthat.user.notice.vo.UserNoticeVO;

public interface UserNoticeService {

	//회원용 공지사항 게시판이라 쓰기,수정,삭제 안해도 됩니다.
	
	//글 상세 조회
	UserNoticeVO getNotice(UserNoticeVO vo);
	
	UserNoticeVO getEvent(UserNoticeVO vo);
	
	//공지사항 글 목록 조회
	List<UserNoticeVO> getNoticeList(UserNoticeVO vo);
	
	//이벤트 글 목록 조회
	List<UserNoticeVO> getEventList(UserNoticeVO vo);
	
	//조회수 올리기
	void plusCnt(int board_no);
	
}
