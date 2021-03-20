package com.thisisthat.admin.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

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
	
	public List<NoticeVO> noticeList(NoticeVO noticeVO){
		return mybatis.selectList("NoticeDAO.noticeList",noticeVO);
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
	
}
