package com.example.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {

		try {
			TimeUnit.SECONDS.sleep(10);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return "AOP practice in Springboot udemy";
	}

	@Override
	public String getFortune(boolean tripWise) {
		// TODO Auto-generated method stub
		if(tripWise) {
			throw new RuntimeException("Handling Exception Example through around advice");
		}
		return getFortune();
	}

}
