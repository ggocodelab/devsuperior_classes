package com.ggocodelab.program08.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggocodelab.program08.dto.PersonDTO;
import com.ggocodelab.program08.dto.PersonDepartmentDTO;
import com.ggocodelab.program08.entities.Department;
import com.ggocodelab.program08.entities.Person;
import com.ggocodelab.program08.repositories.DepartmentRepository;
import com.ggocodelab.program08.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
    private PersonRepository personRepository;
	
	@Autowired
    private DepartmentRepository departmentRepository;
	
	@Transactional
	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
		Person entity = new Person();
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		// carrega o departamento do banco pelo ID
		// Department dept = new Department();
        Department dept = departmentRepository.findById(dto.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
		
		entity.setDepartment(dept);
		entity = personRepository.save(entity);
		return new PersonDepartmentDTO(entity);
	}
	
	public PersonDTO insert(PersonDTO dto) {
		Person entity = new Person();
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		Department dept = departmentRepository.getReferenceById(dto.getDepartmentId());
		//Department dept = new Department();
		//dept.setId(dept.getDepartmentId());
		
		entity.setDepartment(dept);
		
		entity = personRepository.save(entity);
		
		return new PersonDTO(entity);		
	}	
}
