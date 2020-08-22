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
import com.wallet.cloud.skel.util.PageUtil;

@Service("TransactionService")
public class TransactionServiceImpl extends PageUtil implements TransactionService {

	@Autowired
	AccountRepository accrepo;
	@Autowired
	TransactionRepository tranrepo;

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	public Page<Transaction> getAllTransactionsByAccountNumber(int number, int size, String sort,
			String accountnumber) {
		logger.debug("Inside getAllTransactionsByAccountNumber Service");
		Pageable pageableObj = PageUtil.createPageRequest(number, size, sort);

		return tranrepo.findByAccountNumber(pageableObj, accountnumber);
	}

	public Page<Transaction> getAllTransactionByPlayerName(int number, int size, String sort, String playerName) {
		logger.debug("Inside getAllTransactionsByPlayerName Service");
		Pageable pageableObj = PageUtil.createPageRequest(number, size, sort);

		return tranrepo.findByPlayerName(pageableObj, playerName);
	}

}
