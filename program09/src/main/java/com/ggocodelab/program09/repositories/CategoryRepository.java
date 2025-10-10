package com.ggocodelab.program09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggocodelab.program09.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
