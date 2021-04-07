package com.thisisthat.user.item.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.thisisthat.user.item.vo.CommentVO;
import com.thisisthat.user.item.vo.UserItemImageVO;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemSizeGuideVO;
import com.thisisthat.user.item.vo.UserItemSizeUsedVO;
import com.thisisthat.user.item.vo.UserItemVO;
import com.thisisthat.util.PagingVO;

@Controller
public class UserItemListDAO {

	@Autowired
	private SqlSessionTemplate itemListTemplate;
	
	public int getItemCount(String categoryName) {
		return itemListTemplate.selectOne("ItemDAO.getItemCount",categoryName);
	}
	
	public List<UserItemListVO> getItemList(PagingVO pagingvo,String categoryName,String select){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("categoryName", categoryName);
		map.put("select", select);
		map.put("start", pagingvo.getStart());
		return itemListTemplate.selectList("ItemDAO.getItemList",map);
	}
	
	public UserItemVO getItemInfo(long productNo) {
		return itemListTemplate.selectOne("ItemDAO.getItemInfo",productNo);
	}
	
	public List<UserItemImageVO> getItemImage(long productNo){
		return itemListTemplate.selectList("ItemDAO.getItemImage",productNo);
	}
	
	public List<UserItemSizeGuideVO> getItemSizeGuide(long productNo) {
		return itemListTemplate.selectList("ItemDAO.getItemSizeGuide",productNo);
	}
	public UserItemSizeUsedVO getItemSizeUsed(long productNo) {
		return itemListTemplate.selectOne("ItemDAO.getItemSizeUsed",productNo);
	}
	public void insertComment(CommentVO comment) {
		itemListTemplate.insert("ItemDAO.insertComment",comment);	
	}
	public int commentCount(int boardNo) {
		return itemListTemplate.selectOne("commentCount",boardNo);
	}
	public List<CommentVO> getCommentList(PagingVO paging, int boardId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", paging.getStart());
		map.put("cntPerPage", paging.getCntPerPage());
		map.put("boardId", boardId);
		return itemListTemplate.selectList("getCommentList",map);
	}
	public void delComment(int commentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentNo", commentNo);
		map.put("nowDate", new Date());
		itemListTemplate.update("delComment",map);
	}
	
}
