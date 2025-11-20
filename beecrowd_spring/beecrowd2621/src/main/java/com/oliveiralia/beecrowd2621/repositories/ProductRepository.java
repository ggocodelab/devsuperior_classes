package com.oliveiralia.beecrowd2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oliveiralia.beecrowd2621.dto.ProductMinDTO;
import com.oliveiralia.beecrowd2621.entities.Product;
import com.oliveiralia.beecrowd2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long>{
	//SQL
	@Query(nativeQuery = true, value = "SELECT products.name "
			+ "FROM products "
			+ "INNER JOIN providers ON products.id_providers = providers.id "
			+ "WHERE products.amount BETWEEN :min AND :max "
			+ "AND providers.name LIKE CONCAT(:beginName, '%')")
	List<ProductMinProjection> search1(Integer min, Integer max, String beginName);
	
	//JPQL
	// Product classe no FROM
	// Use o DTO ao invés da Projection
	// Quando o relacionamento é para um, não é necessário fazer o inner join. É possível navegar no próprio objeto.
	@Query("SELECT new com.oliveiralia.beecrowd2621.dto.ProductMinDTO(obj.name) "
			+ "FROM Product obj "
			+ "WHERE obj.amount BETWEEN :min AND :max "
			+ "AND obj.provider.name LIKE CONCAT(:beginName, '%')")
	List<ProductMinDTO> search2(Integer min, Integer max, String beginName);

}
