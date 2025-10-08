package com.ggocodelab.dscommercev2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggocodelab.dscommercev2.dto.ProductDTO;
import com.ggocodelab.dscommercev2.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		ProductDTO dto = service.findById(1L);
		return dto;
	}	
}
