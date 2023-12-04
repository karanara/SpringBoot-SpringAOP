package com.example.spring.aopdemo;

import java.util.List;

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
			
			demoMethodForAfterAdvice(accountDAO);
			//demoMethodForAOP(accountDAO,membershipDAO);
		};
	}

	private void demoMethodForAfterAdvice(AccountDAO accountDAO) {
		// TODO Auto-generated method stub
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("Accounts: : " + accounts);
		
	}

	private void demoMethodForAOP(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub
		Account account= new Account("ramya","karanam");
		accountDAO.addAccount(account,true);
		accountDAO.setName("Joshna");
		accountDAO.setServiceCode("123");
		System.out.println(accountDAO.getName());
		System.out.println(accountDAO.getServiceCode());
		System.out.println(membershipDAO.addMemberAccount());
	}
}
