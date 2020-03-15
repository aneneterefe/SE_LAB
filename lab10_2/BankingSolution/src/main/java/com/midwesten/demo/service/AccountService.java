package com.midwesten.demo.service;

import java.util.List;

import com.midwesten.demo.model.Account;

public interface AccountService {

	public abstract Account saveAccount(Account account);
	public abstract List<Account> getAllAccounts(Integer pageNo, Integer pageSize, String sortedBy);
	public abstract Double computeNetLiquidity();
	public abstract void deleteAccount(Long id);
	
    
}
