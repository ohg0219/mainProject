package com.thisisthat.user.item.service;

import java.util.List;

import com.thisisthat.user.item.vo.CommentVO;
import com.thisisthat.user.item.vo.UserItemImageVO;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemSizeGuideVO;
import com.thisisthat.user.item.vo.UserItemSizeUsedVO;
import com.thisisthat.user.item.vo.UserItemVO;
import com.thisisthat.util.PagingVO;

public interface UserItemListService {

	int getItemCount(String categoryName,String keyword);
	List<UserItemListVO> getItemList(PagingVO pagingvo,String categoryName,String keyword,String select);
	UserItemVO getItemInfo(long productNo);
	List<UserItemImageVO> getItemImage(long productNo);
	List<UserItemSizeGuideVO> getItemSizeGuide(long productNo);
	UserItemSizeUsedVO getItemSizeUsed(long productNo);
	void insertComment(CommentVO comment);
	int commentCount(int boardNo);
	List<CommentVO> getCommentList(PagingVO paging, int boardId);
	void delComment(int commentNo);
	public boolean isBuyer(String userId, int productNo);
}
