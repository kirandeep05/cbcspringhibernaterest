package com.cbc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("withinProgramguideRestPointcut()")
	public void loggingBefore(JoinPoint jp) {
		System.out.println("Before Joinpoint is "+jp.getArgs().toString());
	}
	
	@After("withinProgramguideRestPointcut()")
	public void loggingAfter(JoinPoint jp) {
		System.out.println("After Joinpoint is "+jp.getTarget().toString());
	}
	
	//@Pointcut("within(com.cbc.rest.controller.ProgramGuideRest))")
	@Pointcut("execution(* com.cbc.rest..controller..*(..))")
	public void withinProgramguideRestPointcut() {
		
	}

}
