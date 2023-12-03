package com.example.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectDemoClass {

	@Pointcut("execution(* com.example.spring.aopdemo.dao.*.*(..))")
	public void AdviceForPackage() {}
	
	
	@Before("AdviceForPackage()")
	public void BeforeMethodExecution() {
		System.out.println("Execution-------------- using before advice  Aspect Oriented Programming");
		
	}
	@Before("AdviceForPackage()")
	public void PerformAPIDesign() {
		System.out.println("Performing api deisgn at Before advice");
	}
}
