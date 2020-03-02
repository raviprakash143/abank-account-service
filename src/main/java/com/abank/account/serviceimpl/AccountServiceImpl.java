package com.abank.account.serviceimpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abank.account.domain.BankAccount;
import com.abank.account.repository.AccountRepository;
import com.abank.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	public BankAccount createAccount(BankAccount account)
	{
		BankAccount accountObj = accountRepository.save(account);
		return accountObj;
	}

	@Override
	public BankAccount findByAccountNumber(String accountNumber) {
		Optional<BankAccount> accountObj = accountRepository.findById(accountNumber);
		return accountObj.get();
	}

	@Override
	public Set<BankAccount> findByAccountByCustomerId(String customerId) {
		Set<BankAccount> accountObj = accountRepository.findByCustomerId(customerId);
		return accountObj;
	}

	@Override
	public double getBalance(String accountNumber) {
		Optional<BankAccount> account = accountRepository.findById(accountNumber);
		double amount = account.get().getAmount();
		return amount;
	}

	@Override
	public String depositeAmount(BankAccount bankAccount) {
		double balanceAmount = 0.0;
		String flag;
		Optional<BankAccount> account = accountRepository.findById(bankAccount.getAccountNumber());
		if(account.isPresent())
		{
			BankAccount accountObj = account.get();
			balanceAmount = accountObj.getAmount()+bankAccount.getAmount();
			accountObj.setAmount(balanceAmount);
			accountRepository.save(accountObj);
			flag = "Deposite Successfully";
		}
		else
		{
			flag = "Account not found";
		}
		return flag;
	}

	@Override
	public String withDrawAmount(BankAccount bankAccount) {
		double balanceAmount = 0.0;
		String flag;
		Optional<BankAccount> account = accountRepository.findById(bankAccount.getAccountNumber());
		if(account.isPresent())
		{
			BankAccount accountObj = account.get();
			balanceAmount = accountObj.getAmount();
			if(balanceAmount > bankAccount.getAmount())
			{
				balanceAmount = balanceAmount-bankAccount.getAmount();
				accountObj.setAmount(balanceAmount);
				accountRepository.save(accountObj);
				flag = "With darw "+bankAccount.getAmount()+" Successfully";				
			}
			else
			{
				flag = "Insufficient funds";	
			}
			
		}
		else
		{
			flag = "Account not found";
		}
		return flag;
	}
}
