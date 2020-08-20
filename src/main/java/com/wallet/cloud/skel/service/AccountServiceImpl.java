package com.wallet.cloud.skel.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Player;
import com.wallet.cloud.skel.model.Transaction;
import com.wallet.cloud.skel.repository.AccountRepository;
import com.wallet.cloud.skel.repository.PlayerRepository;
import com.wallet.cloud.skel.repository.TransactionRepository;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accrepo;
	@Autowired
	TransactionRepository tranrepo;
	@Autowired
	PlayerRepository prepo;

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	// public Page<Account> getAllAccounts(Pageable pageable, String number, String
	// size, String sort) {
	public Page<Account> getAllAccounts(int number, int size, String sort) {
		logger.info("In getAllAccountsService");
		Pageable pageableObj = createPageRequest(number, size, sort);
		return accrepo.findAll(pageableObj);
	}

	@SuppressWarnings("deprecation")
	private Pageable createPageRequest(int number, int size, String sort) {
		// Create a new Pageable object here.
		Sort sorting;

		if (sort.equalsIgnoreCase("ASC")) {
			sorting = new Sort(new Sort.Order(Direction.ASC, "accountNumber"));
		} else {
			sorting = new Sort(new Sort.Order(Direction.DESC, "accountNumber"));
		}
		Pageable pageables = new PageRequest(number, size, sorting);
		return pageables;
	}

	public Account creditAccount(String name, Long credit_amount, Long transactionId) {
		try {
			Optional<Transaction> tr = tranrepo.findBymId(transactionId);
			logger.info("In creditAccountService");
			if (tr.isPresent() == false) {

				Player pl = prepo.findByName(name);
				logger.info("Player" + pl);
				Account acc = accrepo.findBymId(pl.getAccount().getId());
				Long balance = acc.getBalance();
				Long final_amount = balance + credit_amount;
				acc.setBalance(final_amount);
				Transaction transaction = tranrepo.save(new Transaction(acc.getAccountNumber(), pl.getName(),
						credit_amount, acc.getBalance(), new Timestamp(System.currentTimeMillis())));
				return acc;
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			logger.error("Transaction id should be Unique");
		}
		return null;
	}

	public Account debitAccount(String name, Long debit_amount, Long transactionId) {
		try {
			Optional<Transaction> tr = tranrepo.findBymId(transactionId);
			logger.info("In debitAccountService");
			if (tr.isPresent() == false) {

				Player pl = prepo.findByName(name);
				Account acc = accrepo.findBymId(pl.getAccount().getId());
				Long balance = acc.getBalance();
				Long final_balance = 0l;
				if (balance > 0 && balance - debit_amount >= 0) {
					final_balance = balance - debit_amount;
				} else {
					throw new Exception();
				}
				acc.setBalance(final_balance);
				Transaction transaction = tranrepo.save(new Transaction(acc.getAccountNumber(), pl.getName(),
						debit_amount, acc.getBalance(), new Timestamp(System.currentTimeMillis())));
				return acc;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("Transaction id should be Unique and also maintain minimum balance above O");
		}
		return null;
	}

}
