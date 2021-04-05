package com.thisisthat.user.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thisisthat.admin.usermanagement.vo.UserVO;

@Aspect
public class ServiceLog {
	private static final Logger logger = LoggerFactory.getLogger(ServiceLog.class);
	
	
	@Pointcut("within(com.thisisthat.*.*.service..*)")
    private void publicTarget() {
    }

	
	
	@Around("publicTarget()")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {	
		
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		HttpSession session = null;
		HttpServletRequest request = null;
		 for ( Object o : pjp.getArgs() ){
			 if ( o instanceof HttpServletRequest ) {
				 System.out.println("들어옴");
	                request = (HttpServletRequest)o;
	                session = request.getSession();
	            }

	        }
		if(session != null) {
			UserVO user = (UserVO)session.getAttribute("adminId");
			logger.info("실행한 사람 : "+user.getUserId());
		}
		//실제 타겟을 실행하는 부분이다. 이 부분이 없으면 advice가 적용된 메소드가 동작을 안할것 같다.
		Object result = pjp.proceed();  //proceed는 Exception 보다 상위 Throwable을 처리해야 한다.

		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName() + "메소드 실행됨 ");  //target 메소드의 동작 시간을 출력한다.
		logger.info("수행 시간 : " + ( endTime - startTime));
		logger.info("==============================");

		//Around를 사용할 경우 반드시 Object를 리턴해야 한다.
		return result;
	}
}
