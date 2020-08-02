package com.cepheid.cloud.skel.repository;

import java.util.List;
import java.util.Optional;
import com.cepheid.cloud.skel.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cepheid.cloud.skel.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query("FROM Item WHERE name= ?1")
	Item findByName(String name);
	@Query("FROM Item WHERE state= ?1")
	List<Item> findAllByState(State state);
	
	Optional<Item> findById(Long id);
	
	List<Item> findAll();
	
	void deleteById(Long Id);
	
	//Item save(Item i);
	
	
	 
	 

}
