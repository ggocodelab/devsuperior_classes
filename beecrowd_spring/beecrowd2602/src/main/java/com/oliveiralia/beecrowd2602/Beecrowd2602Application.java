package com.oliveiralia.beecrowd2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oliveiralia.beecrowd2602.dto.CustomerMinDTO;
import com.oliveiralia.beecrowd2602.projections.CustomerMinProjection;
import com.oliveiralia.beecrowd2602.repositories.CustomerRepository;

@SpringBootApplication
public class Beecrowd2602Application implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Beecrowd2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Bom dia!");
		//List<CustomerMinProjection> list = repository.search1("RS");
		//for(CustomerMinProjection obj: list) {
		//	System.out.println(obj.getName());
		//}
		
		List<CustomerMinProjection> list = repository.search1("RS");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
		
		for(CustomerMinDTO obj: result1) {
			System.out.println(obj);
		}
	}
}
