package com.midwesten.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="accountType")
public class AccountType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountTypeId;
	
	@Column(nullable = false)
	@NotBlank(message = "Account Type name Can't be blank")
	private String accountTypeName;
	
	@OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Account> accounts=new ArrayList<>();

	public AccountType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountType(@NotBlank(message = "Account Type name Can't be blank") String accountTypeName,
			List<Account> accounts) {
		super();
		this.accountTypeName = accountTypeName;
		this.accounts = accounts;
	}
	
	public AccountType(@NotBlank(message = "Account Type name Can't be blank") String accountTypeName) {
		super();
		this.accountTypeName = accountTypeName;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
	
	
}
