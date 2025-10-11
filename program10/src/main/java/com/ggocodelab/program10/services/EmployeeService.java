package com.ggocodelab.program10.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggocodelab.program10.dtos.EmployeeDTO;
import com.ggocodelab.program10.dtos.EmployeeDepartmentDTO;
import com.ggocodelab.program10.entities.Employee;
import com.ggocodelab.program10.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Transactional(readOnly = true)
	public EmployeeDTO findEmployeeById(Long id) {
		Optional<Employee> result = repository.findById(id);
		return new EmployeeDTO(result.get());
	}
	
	@Transactional(readOnly = true)
	public EmployeeDepartmentDTO findByIdWithDepartment(Long id) {
		Optional<Employee> result = repository.findById(id);
		return new EmployeeDepartmentDTO(result.get());
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeDepartmentDTO> findEmployeesWithDepartments(){
		List<Employee> result = repository.findEmployeesWithDepartments();
		return result.stream().map(x -> new EmployeeDepartmentDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findByName(String name) {
		List<Employee> result = repository.findByName(name);
		return result.stream().map(x -> new EmployeeDTO(x)).toList();
	}
	
	
}
