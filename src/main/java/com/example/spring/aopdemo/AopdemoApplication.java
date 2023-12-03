package com.example.spring.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.spring.aopdemo.dao.Account;
import com.example.spring.aopdemo.dao.AccountDAO;
import com.example.spring.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean 
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		
		return  runner->{
			
			demoMethodForAOP(accountDAO,membershipDAO);
		};
	}

	private void demoMethodForAOP(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub
		Account account= new Account("ramya","karanam");
		accountDAO.addAccount(account,true);
		System.out.println(membershipDAO.addMemberAccount());
	}
}
