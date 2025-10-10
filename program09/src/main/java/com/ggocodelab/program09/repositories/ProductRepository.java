package com.ggocodelab.program09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggocodelab.program09.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
