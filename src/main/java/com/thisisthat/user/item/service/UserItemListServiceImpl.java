package com.thisisthat.user.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.item.dao.UserItemListDAO;
import com.thisisthat.user.item.vo.CommentVO;
import com.thisisthat.user.item.vo.UserItemImageVO;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemSizeGuideVO;
import com.thisisthat.user.item.vo.UserItemSizeUsedVO;
import com.thisisthat.user.item.vo.UserItemVO;
import com.thisisthat.util.PagingVO;

@Service
public class UserItemListServiceImpl implements UserItemListService {

	@Autowired
	private UserItemListDAO itemListDAO;
	
	@Override
	public List<UserItemListVO> getItemList(PagingVO pagingvo,String categoryName,String keyword,String select) {
		return itemListDAO.getItemList(pagingvo,categoryName,keyword,select);
	}

	@Override
	public UserItemVO getItemInfo(long productNo) {
		return itemListDAO.getItemInfo(productNo);
	}

	@Override
	public List<UserItemImageVO> getItemImage(long productNo) {
		return itemListDAO.getItemImage(productNo);
	}

	@Override
	public List<UserItemSizeGuideVO> getItemSizeGuide(long productNo) {
		return itemListDAO.getItemSizeGuide(productNo);
	}

	@Override
	public UserItemSizeUsedVO getItemSizeUsed(long productNo) {
		return itemListDAO.getItemSizeUsed(productNo);
	}

	@Override
	public void insertComment(CommentVO comment) {
		itemListDAO.insertComment(comment);
	}
	@Override
	public int commentCount(int boardNo) {
		return itemListDAO.commentCount(boardNo);
	}

	@Override
	public List<CommentVO> getCommentList(PagingVO paging, int boardId) {
		return itemListDAO.getCommentList(paging, boardId);
	}

	@Override
	public void delComment(int commentNo) {
		itemListDAO.delComment(commentNo);
	}

	@Override
	public boolean isBuyer(String userId,int productNo) {
		
		return itemListDAO.isBuyer(userId, productNo);
	}
	public int getItemCount(String categoryName,String keyword) {
		return itemListDAO.getItemCount(categoryName,keyword);
	}

}
