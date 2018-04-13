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
		Dummy d = s->System.out.println(s+ "Joinpoint is "+jp.getArgs().toString());
		d.test("before");
	}
	
	@After("withinProgramguideRestPointcut()")
	public void loggingAfter(JoinPoint jp) {
		Dummy d = s->System.out.println(s+ "Joinpoint is "+jp.getArgs().toString());
		d.test("after");	
	}
	
	//@Pointcut("within(com.cbc.rest.controller.ProgramGuideRest))")
	@Pointcut("execution(* com.cbc.rest..controller..*(..))")
	public void withinProgramguideRestPointcut() {
		
	}

}

@FunctionalInterface
interface Dummy {
	
	public void test(String s);
}