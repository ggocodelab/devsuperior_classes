package com.ggocodelab.program09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggocodelab.program09.dto.CategoryDTO;
import com.ggocodelab.program09.dto.ProductDTO;
import com.ggocodelab.program09.entities.Category;
import com.ggocodelab.program09.entities.Product;
import com.ggocodelab.program09.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		
		for(CategoryDTO catDto : dto.getCategories()) {
			Category cat = new Category();
			cat.setId(catDto.getId());
			entity.getCategories().add(cat);
		}
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

}
