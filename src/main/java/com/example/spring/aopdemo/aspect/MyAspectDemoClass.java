package com.example.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectDemoClass {

	@Pointcut("execution(* com.example.spring.aopdemo.dao.*.*(..))")
	private void AdviceForPackage() {}
	
    @Pointcut("execution(* com.example.spring.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.example.spring.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("AdviceForPackage() && !(getter() || setter())")
	private void adviceForNoSetterAndGetter() {}
	
	@Before("adviceForNoSetterAndGetter()")
	public void BeforeMethodExecution() {
		System.out.println("Execution-------------- using before advice  Aspect Oriented Programming");
	
	}
}
