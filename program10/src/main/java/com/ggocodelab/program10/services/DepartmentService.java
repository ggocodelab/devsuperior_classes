package com.ggocodelab.program10.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggocodelab.program10.dtos.DepartmentDTO;
import com.ggocodelab.program10.dtos.EmployeeDTO;
import com.ggocodelab.program10.entities.Department;
import com.ggocodelab.program10.entities.Employee;
import com.ggocodelab.program10.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Transactional(readOnly = true)
	public DepartmentDTO findById(long id) {
		Optional<Department> result = repository.findById(id);
		return new DepartmentDTO(result.get());
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findEmployeesByDepartment(Long id) {
		Optional<Department> result = repository.findById(id);
		List<Employee> list = result.get().getEmployees();
		return list.stream().map(x -> new EmployeeDTO(x)).toList();
	}
}
