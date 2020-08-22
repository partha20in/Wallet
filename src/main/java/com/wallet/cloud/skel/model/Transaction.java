package com.wallet.cloud.skel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "transaction", indexes = {
		@Index(name = "wallet_transaction", columnList = "accountNumber,playername,transactionAmount,finalBalance") })
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;

	private Long transactionId;

	private String accountNumber;

	private String playerName;

	private BigDecimal transactionAmount;

	private BigDecimal finalBalance;

	private Timestamp transactionDateTime;

	public Transaction() {
		super();
	}

	public Transaction(Long transactionId, String accountNumber, String playerName, BigDecimal transactionAmount,
			BigDecimal finalBalance, Timestamp transactionDateTime) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.playerName = playerName;
		this.transactionAmount = transactionAmount;
		this.finalBalance = finalBalance;
		this.transactionDateTime = transactionDateTime;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public void setId(Long Id) {
		this.id = Id;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(BigDecimal finalBalance) {
		this.finalBalance = finalBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Timestamp transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	@Override
	public String toString() {
		return "Transaction [Id=" + id + ", transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", playerName=" + playerName + ", transactionAmount=" + transactionAmount + ", finalBalance="
				+ finalBalance + ", transactionDateTime=" + transactionDateTime + "]";
	}

}
