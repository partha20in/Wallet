package com.wallet.cloud.skel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wallet.cloud.skel.model.*;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>{

	//@Query("FROM Account WHERE mId= ?1")
	Account findBymId(Long id);
	
	@SuppressWarnings("unchecked")
	Account save(Account acc);

}
