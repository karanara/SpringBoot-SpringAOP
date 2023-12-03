package com.example.spring.aopdemo.dao;

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

}
