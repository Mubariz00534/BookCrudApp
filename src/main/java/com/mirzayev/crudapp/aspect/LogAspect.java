package com.mirzayev.crudapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Aspect
@Component
public class LogAspect {

	private Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("bean(*Controller)")
	public Object logBeforeAllMethods(ProceedingJoinPoint jp) throws Throwable {
		// Output start log
		logger.info("Method start: " + jp.getSignature());
		try {
			
			Object result = jp.proceed();
			
			logger.info("Method end: " + jp.getSignature());
			
			return result;
		} catch (Exception e) {
			
			logger.error("Method abend: " + jp.getSignature());
			
			throw e;
		}
	}

//	@Before("execution(* com.mirzayev.crudapp.controller.BookController.getAllBooks(..))")
//	public void logBeforeGetAllBooks(JoinPoint joinPoint) {
//		logger.debug("***LogAspect log before get All Books method(): " + joinPoint.getSignature().getName());
//	}
}
