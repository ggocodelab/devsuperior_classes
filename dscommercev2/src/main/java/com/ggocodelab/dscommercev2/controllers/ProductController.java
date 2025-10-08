package com.ggocodelab.dscommercev2.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggocodelab.dscommercev2.entities.Product;
import com.ggocodelab.dscommercev2.repositories.ProductRepository;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	//@GetMapping
	//private String teste() {
		//return "Olá mundo!";
	//}
	
	@GetMapping
	public String teste() {
		Optional<Product> result = repository.findById(1L);
		Product product = result.get();
		return product.getName();
	}	
}
