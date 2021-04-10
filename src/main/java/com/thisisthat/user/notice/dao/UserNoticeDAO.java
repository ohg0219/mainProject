package com.thisisthat.user.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.thisisthat.user.notice.vo.UserNoticeVO;
import com.thisisthat.util.PagingVO;

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
	
	public int noticeCount(String searchOption, String keyword,String group) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("group", group);
		System.out.println((Integer)userNoticeTemplate.selectOne("UserNoticeM.noticeCount", map));
		return userNoticeTemplate.selectOne("UserNoticeM.noticeCount", map);
	}
	
	public List<UserNoticeVO> noticeList(PagingVO paging, String searchOption, String keyword){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(paging.toString());
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("cntPerPage", paging.getCntPerPage());
		map.put("start", paging.getStart());
		List<UserNoticeVO> ad = userNoticeTemplate.selectList("UserNoticeM.noticeList", map);
		System.out.println(ad.size());
		return userNoticeTemplate.selectList("UserNoticeM.noticeList", map);
	}
	
	public List<UserNoticeVO> eventList(PagingVO paging, String searchOption, String keyword){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(paging.toString());
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("cntPerPage", paging.getCntPerPage());
		map.put("start", paging.getStart());
		List<UserNoticeVO> ad = userNoticeTemplate.selectList("UserNoticeM.eventList", map);
		System.out.println(ad.size());
		return userNoticeTemplate.selectList("UserNoticeM.eventList", map);
	}
	
	//서치하는 DAO 메서드
	/*
	public List<UserNoticeVO> allNotice(UserNoticeVO vo){
		return userNoticeTemplate.selectList("UserNoticeM.allNotice", vo);
	}
	
	public List<UserNoticeVO> titleNotice(UserNoticeVO vo){
		return userNoticeTemplate.selectList("UserNoticeM.titleNotice", vo);
	}
	
	public List<UserNoticeVO> writerNotice(UserNoticeVO vo){
		return userNoticeTemplate.selectList("UserNoticeM.writerNotice", vo);
	}
	
	public List<UserNoticeVO> contentNotice(UserNoticeVO vo){
		return userNoticeTemplate.selectList("UserNoticeM.contentNotice", vo);
	}
	*/
}
