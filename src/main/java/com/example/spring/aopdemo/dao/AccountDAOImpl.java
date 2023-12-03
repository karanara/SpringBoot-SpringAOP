package com.example.spring.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		System.out.println("Excecution of a account method in AOP");

	}

}
