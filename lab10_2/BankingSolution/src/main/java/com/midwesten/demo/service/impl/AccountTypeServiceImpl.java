package com.midwesten.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midwesten.demo.model.AccountType;
import com.midwesten.demo.repository.AccountTypeRepository;
import com.midwesten.demo.service.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

	private AccountTypeRepository accountTypeRepository;
	
	@Autowired
	public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
		// TODO Auto-generated constructor stub
		this.accountTypeRepository=accountTypeRepository;
	}
	@Override
	public List<AccountType> getAllAccountTypes() {
		// TODO Auto-generated method stub
		return accountTypeRepository.findAll();
	}

}
