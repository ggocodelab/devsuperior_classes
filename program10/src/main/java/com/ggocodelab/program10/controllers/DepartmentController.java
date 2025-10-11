package com.ggocodelab.program10.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggocodelab.program10.dtos.DepartmentDTO;
import com.ggocodelab.program10.dtos.EmployeeDTO;
import com.ggocodelab.program10.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
		DepartmentDTO obj = service.findById(id);
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping(value = "/{id}/employees")
	public ResponseEntity<List<EmployeeDTO>> findEmployeesByDepartment(@PathVariable Long id) {
		List<EmployeeDTO> list = service.findEmployeesByDepartment(id);
		return ResponseEntity.ok(list);
	}
}
