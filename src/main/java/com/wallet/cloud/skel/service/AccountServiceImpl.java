package com.wallet.cloud.skel.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import com.wallet.cloud.skel.util.*;

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
import com.wallet.cloud.skel.util.PageUtil;

@Service("AccountService")
public class AccountServiceImpl extends PageUtil implements AccountService {

	@Autowired
	AccountRepository accrepo;
	@Autowired
	TransactionRepository tranrepo;
	@Autowired
	PlayerRepository prepo;

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	public Page<Account> getAllAccounts(int number, int size, String sort) {
		logger.info("In getAllAccountsService");
		Pageable pageableObj = PageUtil.createPageRequest(number, size, sort);

		return accrepo.findAll(pageableObj);
	}

	public Account creditAccount(String name, BigDecimal credit_amount, Long transactionId) {
		try {
			Optional<Transaction> tr = tranrepo.findByTransactionId(transactionId);
			logger.info("In creditAccountService");
			if (tr.isPresent() == false) {

				Player pl = prepo.findByName(name);
				logger.info("Player" + pl);
				Optional<Account> acc = accrepo.findById(pl.getAccount().getId());
				Account a;
				if (acc.isPresent()) {
					a = acc.get();
					BigDecimal balance = a.getBalance();
					if (credit_amount.compareTo(BigDecimal.ZERO) == 1) {
						BigDecimal final_amount = balance.add(credit_amount);
						a.setBalance(final_amount);
						tranrepo.save(new Transaction(transactionId, a.getAccountNumber(), pl.getName(), credit_amount,
								a.getBalance(), new Timestamp(System.currentTimeMillis())));
					}
				} else {
					throw new Exception();
				}
				return a;
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			logger.error("Transaction id should be Unique");
		}
		return null;
	}

	public Account debitAccount(String name, BigDecimal debit_amount, Long transactionId) {
		try {
			Optional<Transaction> tr = tranrepo.findByTransactionId(transactionId);
			logger.info("In debitAccountService");
			if (tr.isPresent() == false) {

				Player pl = prepo.findByName(name);
				Optional<Account> acc = accrepo.findById(pl.getAccount().getId());
				Account a;
				BigDecimal final_balance;
				if (acc.isPresent()) {
					a = acc.get();
					BigDecimal balance = a.getBalance();
					final_balance = new BigDecimal(0);
					Double debit_amt = debit_amount.doubleValue();
					Double balanc = balance.doubleValue();
					if (balanc > 0 && debit_amt > 0 && balanc - debit_amt >= 0) {

						final_balance = balance.subtract(debit_amount);
						a.setBalance(final_balance);
					} else {
						throw new Exception();
					}
				} else {
					throw new Exception();
				}

				tranrepo.save(new Transaction(transactionId, a.getAccountNumber(), pl.getName(), debit_amount,
						a.getBalance(), new Timestamp(System.currentTimeMillis())));
				return a;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("Transaction id should be Unique and also maintain minimum balance above O");
		}
		return null;
	}

}
