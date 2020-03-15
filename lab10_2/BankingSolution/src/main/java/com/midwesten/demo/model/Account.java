package com.midwesten.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;


@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@Column(nullable = false)
	@NotNull(message = "Account Number Can't be blank")
	@Digits(integer = 5, fraction = 0)
	private Long accountNumber;

	@Column(nullable = false)
	@NotNull(message = "Account Balance Can't be blank")
	@Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private Double accountBalance;
	
	@ManyToOne
	@JoinColumn(name="customer_id", nullable = false)
    private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="accountType_id", nullable = false)
    private AccountType accountType;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(
			@NotBlank(message = "Account Number Can't be blank") @Digits(integer = 5, fraction = 0) Long accountNumber,
			@NotBlank(message = "Account Balance Can't be blank") @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'") Double accountBalance,
			Customer customer, AccountType accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.customer = customer;
		this.accountType = accountType;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

		
}
