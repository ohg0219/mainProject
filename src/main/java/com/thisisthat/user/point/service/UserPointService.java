package com.thisisthat.user.point.service;

import java.util.List;

import com.thisisthat.user.point.vo.UserPointVO;


public interface UserPointService {

	List<UserPointVO> pointList(UserPointVO userPointVO);

	UserPointVO pointsum(UserPointVO userPointVO);

	UserPointVO usingSum(UserPointVO userPointVO);

	

}
