package com.ggocodelab.program10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggocodelab.program10.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
