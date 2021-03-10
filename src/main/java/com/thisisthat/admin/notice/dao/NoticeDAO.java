package com.thisisthat.admin.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.notice.vo.NoticeVO;

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
	
	public NoticeVO getNotice(NoticeVO noticeVO) {
		mybatis.update("NoticeDAO.updatecnt", noticeVO);
		return (NoticeVO) mybatis.selectOne("NoticeDAO.getNotice", noticeVO);
	}
	
	public List<NoticeVO> articleList(){
		return mybatis.selectList("NoticeDAO.articleList");
	}
	
	
	
}
