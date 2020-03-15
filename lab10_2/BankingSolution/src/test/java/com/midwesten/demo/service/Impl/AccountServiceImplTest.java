package com.midwesten.demo.service.Impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.midwesten.demo.model.Account;
import com.midwesten.demo.model.AccountType;
import com.midwesten.demo.model.Customer;
import com.midwesten.demo.repository.AccountRepository;
import com.midwesten.demo.service.AccountService;
import com.midwesten.demo.service.impl.AccountServiceImpl;

@SpringBootTest
class AccountServiceImplTest {

	@Mock
	private AccountRepository accountRepository;

	@InjectMocks
	private AccountService accountService=new AccountServiceImpl(accountRepository);

	@BeforeEach
	public void setUp() throws Exception {
		List<Account> accounts = new ArrayList<>();
		AccountType atype = new AccountType();
		atype.setAccountTypeName("Savings");
		Account acc = new Account(10829L, 9999.252, new Customer(), atype);
		accounts.add(acc);
		when(accountRepository.findAll()).thenReturn(accounts);
	}

	@After
	public void tearDown() throws Exception {
		this.accountService = null;
	}

	@Test
	public void testComputeNetLiquidity() {
		
		Double actual = accountService.computeNetLiquidity();
		Double expected = 9999.252;
		assertEquals(expected, actual);
		verify(accountRepository).findAll();
	}

}
