package com.thisisthat.user.phone.service;

import java.util.List;
import java.util.Map;


public interface PhoneService {
	List<String> IdPhone(Map<String, Object> map);
	String PwPhone(Map<String, Object> map);
	void PwUpdate(Map<String, Object> map);
	
	
}