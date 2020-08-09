package com.wallet.cloud.skel.service;



import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Player;
import com.wallet.cloud.skel.model.Transaction;
import com.wallet.cloud.skel.repository.AccountRepository;
import com.wallet.cloud.skel.repository.PlayerRepository;
import com.wallet.cloud.skel.repository.TransactionRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accrepo;
	@Autowired
	TransactionRepository tranrepo;
	@Autowired
	PlayerRepository prepo;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	public List<Account> getAllAccounts(){
		logger.info("In getAllAccountsService");
		return accrepo.findAll();
	}
	
	

	public Account creditAccount(String name,Long credit_amount,Long transactionId) {
		try {
		Optional<Transaction> tr=tranrepo.findByTransactionId(transactionId);
		logger.info("In creditAccountService");
		if(tr.isPresent()==false) {
		
		Player pl=prepo.findByName(name);
		logger.info("Player"+pl);
		Account acc=accrepo.findBymId(pl.getAccount().getId());
		Long balance=acc.getBalance();
		Long final_amount=balance+credit_amount;
		acc.setBalance(final_amount);
		Transaction transaction = tranrepo.save(new Transaction(acc.getAccountNumber(),pl.getName(),credit_amount,acc.getBalance(),new Timestamp(System.currentTimeMillis())));
		return acc;
		}
		else {
			throw new Exception();
		}
		}
		catch(Exception ex){
			logger.error("Transaction id should be Unique");
		}
		return null;
	}
	
	public Account debitAccount(String name,Long debit_amount,Long transactionId)  {
		try {
		Optional<Transaction> tr=tranrepo.findByTransactionId(transactionId);
		logger.info("In debitAccountService");
		if(tr.isPresent()==false) {
		
		Player pl=prepo.findByName(name);
		Account acc=accrepo.findBymId(pl.getAccount().getId());
		Long balance=acc.getBalance();
		Long final_balance=0l;
		if(balance>0 && balance-debit_amount>=0) {
		final_balance=balance-debit_amount;
		}
		else {
			throw new Exception();
		}
		acc.setBalance(final_balance);
		Transaction transaction = tranrepo.save(new Transaction(acc.getAccountNumber(),pl.getName(),debit_amount, acc.getBalance(),new Timestamp(System.currentTimeMillis())));
		return acc;
		}
		else {
			throw new Exception();
		}
		}
		catch(Exception e) {
			logger.error("Transaction id should be Unique and also maintain minimum balance above O");
		}
		return null;
	}

	

}
