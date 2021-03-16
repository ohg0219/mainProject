package com.thisisthat.user.itemlist.sevice;

import java.util.List;

import com.thisisthat.user.itemlist.vo.UserItemListVO;

public interface UserItemListService {

	List<UserItemListVO> getItemList(String categoryName);
}
