package com.thisisthat.admin.notice.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.notice.vo.SearchVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertNotice(NoticeVO noticeVO) {
		mybatis.insert("NoticeDAO.insertNotice", noticeVO);
	}
	
	public void updateNotice(NoticeVO noticeVO) {
		mybatis.update("NoticeDAO.updateNotice", noticeVO);
	}
	
	public void deleteNotice(NoticeVO noticeVO) {
		mybatis.delete("NoticeDAO.deleteNotice", noticeVO);
	}
	
	public NoticeVO notice(NoticeVO noticeVO) {
		return (NoticeVO) mybatis.selectOne("NoticeDAO.notice", noticeVO);
	}

	public List<NoticeVO> allNotice(NoticeVO noticeVO) {
		return mybatis.selectList("NoticeDAO.allNotice",noticeVO);
	}

	public List<NoticeVO> titleNotice(NoticeVO noticeVO) {
		return mybatis.selectList("NoticeDAO.titleNotice",noticeVO);
	}

	public List<NoticeVO> writerNotice(NoticeVO noticeVO) {
		return mybatis.selectList("NoticeDAO.writerNotice",noticeVO);
	}

	public List<NoticeVO> contentNotice(NoticeVO noticeVO) {
		return mybatis.selectList("NoticeDAO.contentNotice",noticeVO);
	}
	
	public String nickname(NoticeVO noticeVO) {
		return mybatis.selectOne("NoticeDAO.nickname", noticeVO);
	}

	public List<NoticeVO> noticeList(PagingVO vo, SearchVO search, NoticeVO noticeVO){
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("searchOption", search.getSearchOption());
		map.put("keyword", search.getKeyword());
		map.put("start", vo.getStart());
		map.put("cntPerPage",vo.getCntPerPage());
		map.put("type",vo.getType());
		map.put("board_group", noticeVO.getBoard_group());
		return mybatis.selectList("NoticeDAO.noticeList",map);
	}
	
	public int totalCount(SearchVO search, NoticeVO noticeVO) {
		HashMap<String, Object>total = new HashMap<String, Object>();
		total.put("board_group", noticeVO.getBoard_group());
		total.put("searchOption", search.getSearchOption());
		total.put("keyword", search.getKeyword());
		return mybatis.selectOne("NoticeDAO.totalCount", total);
	}
	
}
