package com.midwesten.demo.service.Impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.midwesten.demo.model.Account;
import com.midwesten.demo.model.AccountType;
import com.midwesten.demo.model.Customer;
import com.midwesten.demo.repository.AccountRepository;
import com.midwesten.demo.service.impl.AccountServiceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


public class AccountServiceImplTest2 {

    private AccountServiceImpl accountService;

    private AccountRepository accountRepository = mock(AccountRepository.class);

    @Before
    public void setUp() throws Exception {
        this.accountService = new AccountServiceImpl(accountRepository);
    }

    @After
    public void tearDown() throws Exception {
        this.accountService = null;
    }

    @Test
    public void testComputeNetLiquidity() {
    	List<Account> accounts=new ArrayList<>();
    	AccountType atype=new AccountType();
    	atype.setAccountTypeName("Savings");
    	Account acc=new Account(10829L, 9999.25, new Customer(), atype);
    	accounts.add(acc);
    	when(accountRepository.findAll()).thenReturn(accounts);
        Double actual = accountService.computeNetLiquidity();
        Double expected = 9999.25;
        assertEquals(expected, actual);
        verify(accountRepository).findAll();
    }


}
