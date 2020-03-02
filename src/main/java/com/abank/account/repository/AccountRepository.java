package com.abank.account.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abank.account.domain.BankAccount;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount, String> {

	public Set<BankAccount> findByCustomerId(String customerId);
}
