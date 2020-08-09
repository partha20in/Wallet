package com.wallet.cloud.skel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wallet.cloud.skel.model.Account;
import com.wallet.cloud.skel.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	
	@Query("FROM Transaction WHERE accountnumber= ?1")
	List<Transaction> findByAccountNumber(String accountnumber);
	
	@Query("FROM Transaction WHERE playerName= ?1")
	List<Transaction> findByPlayerName(String playerName);
	
	@Query("FROM Transaction WHERE mId= ?1")
	Optional<Transaction> findByTransactionId(Long mId);

	Transaction save(Transaction transaction);

}
