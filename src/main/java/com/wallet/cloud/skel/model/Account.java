package com.wallet.cloud.skel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Index;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account", indexes = { @Index(name = "wallet_account", columnList = "accountNumber,balance") })

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String accountNumber;
	private BigDecimal balance;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
	private Player player;

	public Account() {
		super();
	}

	public Account(String accountNumber, BigDecimal balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long Id) {
		this.id = Id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}

}
