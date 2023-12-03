package com.example.spring.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account account,boolean vip) {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " AccountDAO Method");

	}

}
