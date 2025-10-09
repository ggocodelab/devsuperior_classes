package com.ggocodelab.program08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggocodelab.program08.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
