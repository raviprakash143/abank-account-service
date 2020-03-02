package com.abank.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class BankAccount {

	@Id
	@Column(name="account_number")
	private String accountNumber;
	private String accountType;
	private String ifscCode;
	private double amount;
	private String customerId;
	
	public BankAccount() {}

	public BankAccount(String accountNumber, String accountType, String ifscCode, Double amount, String customerId) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.ifscCode = ifscCode;
		this.amount = amount;
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
