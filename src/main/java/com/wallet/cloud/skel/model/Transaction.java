package com.wallet.cloud.skel.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
    
    @Entity
	@Table(name = "transaction")
	public class Transaction extends AbstractEntity implements Serializable{
	    
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected Long mId;

	    private String accountNumber;
	    
	    private String playerName;

	    private Long transactionAmount;
	    
	    private Long finalBalance;

	    private Timestamp transactionDateTime;
	    
	    
	    
	    
	    public Transaction() {
			super();
		}
	    
	    
		
		public Transaction(String accountNumber, String playerName, Long transactionAmount, Long finalBalance,
				Timestamp transactionDateTime) {
			super();
			this.accountNumber = accountNumber;
			this.playerName = playerName;
			this.transactionAmount = transactionAmount;
			this.finalBalance = finalBalance;
			this.transactionDateTime = transactionDateTime;
		}



		public Long getTransactionId() {
			return mId;
		}



		public void setId(Long Id) {
			this.mId = Id;
		}
		
		public Long getId() {
			return mId;
		}
		
		
		

		public Long getFinalBalance() {
			return finalBalance;
		}



		public void setFinalBalance(Long finalBalance) {
			this.finalBalance = finalBalance;
		}



		public void setTransactionId(Long Id) {
			this.mId = Id;
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



		public Long getTransactionAmount() {
			return transactionAmount;
		}

		public void setTransactionAmount(Long transactionAmount) {
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
			return "Transaction [mId=" + mId + ", accountNumber=" + accountNumber + ", transactionAmount="
					+ transactionAmount + ", transactionDateTime=" + transactionDateTime + "]";
		}

		
		
	    
	}


