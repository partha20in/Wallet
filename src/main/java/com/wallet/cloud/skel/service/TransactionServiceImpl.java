package com.wallet.cloud.skel.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wallet.cloud.skel.controller.AccountController;
import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Transaction;
import com.wallet.cloud.skel.repository.AccountRepository;
import com.wallet.cloud.skel.repository.TransactionRepository;

@Service("TransactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accrepo;
	@Autowired
	TransactionRepository tranrepo;

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	public Page<Transaction> getAllTransactionsByAccountNumber(Pageable pageable,String accountnumber) {
		logger.info("Inside getAllTransactionsByAccountNumber Service");
		return tranrepo.findByAccountNumber(pageable,accountnumber);
	}

	public Page<Transaction> getAllTransactionByPlayerName(Pageable pageable,String playerName) {
		logger.info("Inside getAllTransactionsByPlayerName Service");
		return tranrepo.findByPlayerName(pageable,playerName);
	}
}
