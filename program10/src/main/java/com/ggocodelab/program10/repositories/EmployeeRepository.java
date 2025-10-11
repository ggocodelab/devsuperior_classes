package com.ggocodelab.program10.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ggocodelab.program10.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("SELECT obj FROM Employee obj JOIN FETCH obj.department")
	List<Employee> findEmployeesWithDepartments();

	List<Employee> findByName(String name);

}
