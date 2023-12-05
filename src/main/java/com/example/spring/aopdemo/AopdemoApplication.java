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
			
			//demoMethodForAfterAdvice(accountDAO);
			//demoMethodForAOP(accountDAO,membershipDAO);
			demoMethodAfterThrowing(accountDAO);
		};
	}

	private void demoMethodAfterThrowing(AccountDAO accountDAO) {
		// TODO Auto-generated method stub
		List<Account> accounts=null;
		try {
			boolean tripWise=true;
			accounts=accountDAO.findAccounts(tripWise);
		}
		catch(Exception e) {
			System.out.println("Execution of exception in main method  "+e);
		}
		System.out.println("Accounts in main method throw example  "+accounts);
	}

	private void demoMethodForAfterReturningAdvice(AccountDAO accountDAO) {
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
