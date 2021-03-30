package com.thisisthat.user.item.service;

import java.util.List;

import com.thisisthat.user.item.vo.UserItemImageVO;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemSizeGuideVO;
import com.thisisthat.user.item.vo.UserItemSizeUsedVO;
import com.thisisthat.user.item.vo.UserItemVO;

public interface UserItemListService {

	List<UserItemListVO> getItemList(String categoryName);
	UserItemVO getItemInfo(long productNo);
	List<UserItemImageVO> getItemImage(long productNo);
	List<UserItemSizeGuideVO> getItemSizeGuide(long productNo);
	UserItemSizeUsedVO getItemSizeUsed(long productNo);
	
}
