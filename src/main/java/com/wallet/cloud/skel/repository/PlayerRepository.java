package com.wallet.cloud.skel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wallet.cloud.skel.model.*;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {

//	@Query("FROM Player WHERE name= ?1")
	Optional<Player> findByName(String name);

	
	@SuppressWarnings("unchecked")
	Player save(Player pl);

}
