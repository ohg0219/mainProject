package com.thisisthat.admin.usermanagement.protocol;

public class RoleProtocol {
	final static int TOP_ADMIN = 1; //권한이 가장 높은 관리자
	
	final static int ADMIN = 20;// 직원들
	final static int ADMIN_FREE = 60; // 퇴사한 직원
	
	
	final static int NORMAL_USER = 100; //일반유저
	final static int NORMAL_USER_BLACK = 110; // 블랙리스트 유저
	final static int NORMAL_USER_FREE = 120; // 탈퇴한 유저
}
