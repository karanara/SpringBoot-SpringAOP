package com.example.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExpression {

	@Pointcut("execution(* com.example.spring.aopdemo.dao.*.*(..))")
	public void AdviceForPackage() {}
	
    @Pointcut("execution(* com.example.spring.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.example.spring.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("AdviceForPackage() && !(getter() || setter())")
	public void adviceForNoSetterAndGetter() {}
}
