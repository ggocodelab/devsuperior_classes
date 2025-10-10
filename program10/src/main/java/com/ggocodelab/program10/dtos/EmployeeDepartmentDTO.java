package com.ggocodelab.program10.dtos;

import com.ggocodelab.program10.entities.Employee;

public class EmployeeDepartmentDTO {
	
	private Long id;
	private String name;
	private String email;
	
	private DepartmentDTO department;
	
	public EmployeeDepartmentDTO() {
	}

	public EmployeeDepartmentDTO(Long id, String name, String email, DepartmentDTO department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}
	
	public EmployeeDepartmentDTO(Employee entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.department = new DepartmentDTO(entity.getDepartment());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
}
