package com.ggocodelab.program08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggocodelab.program08.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
