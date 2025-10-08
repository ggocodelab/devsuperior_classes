package com.ggocodelab.dscommercev2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggocodelab.dscommercev2.dto.ProductDTO;
import com.ggocodelab.dscommercev2.entities.Product;
import com.ggocodelab.dscommercev2.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly=true)
	public ProductDTO findById(Long id) {
		Product product = repository.findById(id).orElseThrow(
				() -> new RuntimeException("Produto não encontrado"));
		return new ProductDTO(product);		
	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable){
		Page<Product> result = repository.findAll(pageable);
		return result.map(x -> new ProductDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());
		
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
}
