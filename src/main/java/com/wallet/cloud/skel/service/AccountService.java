package com.wallet.cloud.skel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.wallet.cloud.skel.model.Account;

public interface AccountService {

	Page<Account> getAllAccounts(int number, int size, String sort);

	Account creditAccount(String name, Long credit_amount, Long transactionId);

	Account debitAccount(String name, Long debit_amount, Long transactionId);

}
