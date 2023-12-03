package com.example.spring.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
        System.out.println(getClass() + " MembershipAccount Method");
	}

}
