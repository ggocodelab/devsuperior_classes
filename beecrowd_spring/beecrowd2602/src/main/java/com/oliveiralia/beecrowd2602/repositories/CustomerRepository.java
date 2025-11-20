package com.oliveiralia.beecrowd2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oliveiralia.beecrowd2602.dto.CustomerMinDTO;
import com.oliveiralia.beecrowd2602.entities.Customer;
import com.oliveiralia.beecrowd2602.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	//SQL Query
//	@Query(nativeQuery=true, value="SELECT name "
//			+ "FROM customers "
//			+ "WHERE state= :state")
//	List<CustomerMinProjection> search1(String state);
	
	//SQL Query
	@Query(nativeQuery=true, value="SELECT name "
			+ "FROM customers "
			+ "WHERE UPPER(state) = UPPER(:state)")
	List<CustomerMinProjection> search1(String state);
	
	//JPQL Query
	@Query("SELECT new com.oliveiralia.beecrowd2602.dto.CustomerMinDTO(obj.name)"
			+ "FROM Customer obj "
			+ "WHERE UPPER(obj.state) = UPPER(:state)")
	List<CustomerMinDTO> search2(String state);
}
