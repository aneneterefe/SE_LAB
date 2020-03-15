package com.midwesten.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.midwesten.demo.model.Account;
import com.midwesten.demo.repository.AccountRepository;
import com.midwesten.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		// TODO Auto-generated constructor stub
		this.accountRepository=accountRepository;
	}

	@Override
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts(Integer pageNo, Integer pageSize, String sortedBy) {
		// TODO Auto-generated method stub
		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(sortedBy));
		Page<Account> pagedResult = accountRepository.findAll(paging);
		if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Account>();
        }
	}

	@Override
	public Double computeNetLiquidity() {
		// TODO Auto-generated method stub
		Double savingSum=0.0, checkingSum=0.0, loadSum=0.0;
		List<Account> account=accountRepository.findAll();
		for (Account account2 : account) {
			if(account2.getAccountType().getAccountTypeName().equals("Savings")) {
				savingSum+=account2.getAccountBalance();
			}else if(account2.getAccountType().getAccountTypeName().equals("Loan")) {
				loadSum+=account2.getAccountBalance();
			}else if(account2.getAccountType().getAccountTypeName().equals("Checking")) {
				checkingSum+=account2.getAccountBalance();
			}
		}
		
		return (savingSum+checkingSum)-loadSum;
	}

	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
	}
}
