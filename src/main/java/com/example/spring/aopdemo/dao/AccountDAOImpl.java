package com.example.spring.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private String name;
	private String serviceCode;
	
	public String getName() {
		System.out.println(getClass() +"getName method");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(getClass()+ "setName method");
	}

	public String getServiceCode() {
		System.out.println(getClass() +"getServiceCode method");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		System.out.println(getClass()+ "setServiceCode Method");
	}

	@Override
	public void addAccount(Account account,boolean vip) {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " AccountDAO Method");

	}

	@Override
	public List<Account> findAccounts() {
		// TODO Auto-generated method stub
		return findAccounts(false);
	}
	@Override
	public List<Account> findAccounts(boolean tripWise) {
		// TODO Auto-generated method stub
		if(tripWise==true) {
			throw new RuntimeException("Calling exception in AccountDAOImpl");
		}
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account("joshna","karanam"));
		accounts.add(new Account("package","center"));
		accounts.add(new Account("Spring","Tools"));
		return accounts;
	}

}
