package com.thisisthat.user.email.service;

import java.util.List;
import java.util.Map;

public interface EmailService {
	
	public List<String> getIdEmail(Map<String, Object> map);

	public String getPwEmail(Map<String, Object> map);
	
	public void updatePw(Map<String, Object> map);
	
}
