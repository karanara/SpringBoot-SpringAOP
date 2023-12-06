package com.example.spring.aopdemo.aspect;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.example.spring.aopdemo.service.*.*(..))")
	public Object AroundAdviceHandleExceptionMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AroundAdviceHandleException on method: " + method);
        long start = System.currentTimeMillis();
        Object output=null;
        try {
            output = proceedingJoinPoint.proceed();
        }catch(Exception e) {
        	System.out.println("Exception in AroundAdviceHandleMethodException   "+e);
        	//output="handled exception with advice of Around in AOP";
        	throw e;//rethrow the exception
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Duration : "+(end-start));
		return output;
	}
	
	@Around("execution(* com.example.spring.aopdemo.service.*.*(..))")
	public Object AroundAdviceMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AroundAdvice on method: " + method);
        long start = System.currentTimeMillis();
        Object output = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Duration : "+(end-start));
		return output;
	}
	
	@After("execution(* com.example.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void AfterReturningAdviceMethodExecution(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
	}
	
	@AfterThrowing(pointcut="execution(* com.example.spring.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="Exc")
	public void AfterThrowingAdviceMethodExecution(JoinPoint joinPoint,Throwable Exc) {
		String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n--- >> Executing @AfterThrowing execption:  "+Exc);
	}
	
	@AfterReturning(pointcut="execution(* com.example.spring.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void AfterReturningAdviceMethodExecution(JoinPoint joinPoint,List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> result is: " + result);
        result = result.stream()
                .map(temp -> {
                    temp.setFirstName(temp.getFirstName().toUpperCase());
                    return temp;
                })
                .collect(Collectors.toList());

        System.out.println("Modified Result after preprocessing " + result); 
	}
	
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
