package com.example.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAspectDemoClass {

	
	
	@Before("com.example.spring.aopdemo.aspect.PointCutExpression.adviceForNoSetterAndGetter()")
	public void BeforeMethodExecution() {
		System.out.println(getClass()+"     -------------- using before advice  in Aspect Demo Aspect Oriented Programming");
	
	}
}
