package com.example.spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.spring.aopdemo.dao.Account;

@Aspect
@Component
@Order(3)
public class MyAspectDemoClass {
	
	@Before("com.example.spring.aopdemo.aspect.PointCutExpression.adviceForNoSetterAndGetter()")
	public void BeforeMethodExecution(JoinPoint joinPoint) {
		System.out.println(getClass()+"     -------------- using before advice  in Aspect Demo Aspect Oriented Programming");
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Method ::  "+methodSignature);
	    Object[] args=joinPoint.getArgs();
	    for(Object temp :args) {
	    	System.out.println("argument ::: "+ temp);
	    	if(temp instanceof Account) {
	    		Account account = (Account)temp;
	    		System.out.println("Account First Name :"+account.getFirstName());
	    		System.out.println("Account Last Name  :"+account.getLastName());
	    	}
	    }
	}
}
