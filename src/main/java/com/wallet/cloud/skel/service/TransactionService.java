package com.wallet.cloud.skel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wallet.cloud.skel.model.Transaction;

public interface TransactionService {
	Page<Transaction> getAllTransactionsByAccountNumber(Pageable pageable,String accountnumber);

	Page<Transaction> getAllTransactionByPlayerName(Pageable pageable,String playerName);

}
