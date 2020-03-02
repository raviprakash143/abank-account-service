package com.abank.account.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abank.account.domain.BankAccount;
import com.abank.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/create")
	public BankAccount createAccount(@RequestBody BankAccount account)
	{
		BankAccount accountObj = accountService.createAccount(account);
		return accountObj;
	}
	
	@GetMapping("/findByAccountNumber/{accountNumber}")
	public BankAccount findByAccountNumber(@PathVariable String accountNumber)
	{
		BankAccount accountObj = accountService.findByAccountNumber(accountNumber);
		return accountObj;
	}
	
	@GetMapping("/findByAccountByCustomerId/{customerId}")
	public Set<BankAccount> findByAccountByCustomerId(@PathVariable String customerId)
	{
		Set<BankAccount> accountObj = accountService.findByAccountByCustomerId(customerId);
		return accountObj;
	}
	
	@GetMapping("/getBalance")
	public double getBalance(@RequestParam(value="accountNumber") String accountNumber)
	{
		double balance = accountService.getBalance(accountNumber);
		return balance;
	}
	
	@PostMapping("/depositeAmount")
	public String depositeAmount(@RequestBody BankAccount account)
	{
		String flag = accountService.depositeAmount(account);
		return flag;
	}
	
	@PostMapping("/withDrawAmount")
	public String withDrawAmount(@RequestBody BankAccount account)
	{
		String flag = accountService.withDrawAmount(account);
		return flag;
	}
}
