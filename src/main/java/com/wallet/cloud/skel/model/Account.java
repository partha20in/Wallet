package com.wallet.cloud.skel.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long mId;
	@Column(unique = true)
	private String accountNumber;
	private long balance;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
	private Player player;

	public Account() {
		super();
	}

	public Account(String accountNumber, long balance) {
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

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public Long getId() {
		return mId;
	}

	public void setId(Long Id) {
		this.mId = Id;
	}

	@Override
	public String toString() {
		return "Account [mId=" + mId + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}

}
