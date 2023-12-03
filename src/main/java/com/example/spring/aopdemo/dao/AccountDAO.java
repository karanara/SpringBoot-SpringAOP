package com.example.spring.aopdemo.dao;

public interface AccountDAO {

	public void addAccount(Account theAccount,boolean vip);
	public void setName(String name);
	public void setServiceCode(String code);
	public String getName();
	public String getServiceCode();
}
