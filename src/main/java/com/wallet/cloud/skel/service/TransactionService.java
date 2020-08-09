package com.wallet.cloud.skel.service;



import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.cloud.skel.controller.AccountController;
import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Transaction;
import com.wallet.cloud.skel.repository.AccountRepository;
import com.wallet.cloud.skel.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	AccountRepository accrepo;
	@Autowired
	TransactionRepository tranrepo;
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	public List<Transaction> getAllTransactionsByAccountNumber(String accountnumber){
		logger.info("Inside getAllTransactionsByAccountNumber Service");
		return tranrepo.findByAccountNumber(accountnumber);
	}
	
	public List<Transaction> getAllTransactionByPlayerName(String playerName){
		logger.info("Inside getAllTransactionsByPlayerName Service");
		return tranrepo.findByPlayerName(playerName);
	}
}
