package com.thisisthat.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.client.protocol.RequestAddCookies;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.log.service.LogService;
import com.thisisthat.log.vo.LogVO;

@Aspect
public class ServiceLog {
	private static final Logger logger = LoggerFactory.getLogger(ServiceLog.class);
	
	@Autowired
	LogService logService;
	
	@Pointcut("within(com.thisisthat.*.*.service..*)")
    private void publicTarget() {
    }

	
	
	@Around("publicTarget()")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {	
		
		long startTime = System.currentTimeMillis();
		LogVO log = new LogVO();
		
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
		if(session.getAttribute("adminId") != null) {
			UserVO admin =(UserVO)session.getAttribute("adminId");
			log.setAdminId(admin.getUserId());
			System.out.println("관리자 ID : "+admin.getUserId());
		}
		if(session.getAttribute("userId") != null) {
			String user = (String)session.getAttribute("userId");
			log.setUserId(user);
			logger.info("유저 ID : "+user);
		}
		//실제 타겟을 실행하는 부분이다. 이 부분이 없으면 advice가 적용된 메소드가 동작을 안할것 같다.
		Object result = pjp.proceed();  //proceed는 Exception 보다 상위 Throwable을 처리해야 한다.
		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getDeclaringTypeName() +"."+pjp.getSignature().getName() + " 실행됨 ");
		logger.info("수행 시간 : " + ( endTime - startTime));
		logger.info("==============================");
		log.setPerformanceMethod(pjp.getSignature().getDeclaringTypeName() +"."+pjp.getSignature().getName());
		log.setPerformanceTime(endTime - startTime);
		//Around를 사용할 경우 반드시 Object를 리턴해야 한다.
		System.out.println(log.toString());
		logService.insertLog(log);
		return result;
	}
}
