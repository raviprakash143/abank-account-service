package com.abank.account.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.abank.account.domain.BankAccount;

@Service
public interface AccountService {

	public BankAccount createAccount(BankAccount account);
	public BankAccount findByAccountNumber(String accountNumber);
	public Set<BankAccount> findByAccountByCustomerId(String customerId);
	public double getBalance(String accountNumber);
	public String depositeAmount(BankAccount account);
	public String withDrawAmount(BankAccount account);
}
