package com.wallet.cloud.skel.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.wallet.cloud.skel.model.Account;

public interface AccountService {

	Page<Account> getAllAccounts(int number, int size, String sort);

	Account creditAccount(String name, BigDecimal credit_amount, Long transactionId);

	Account debitAccount(String name, BigDecimal debit_amount, Long transactionId);

}
