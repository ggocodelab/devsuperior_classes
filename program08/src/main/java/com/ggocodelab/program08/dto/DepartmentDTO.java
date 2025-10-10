package com.ggocodelab.program08.dto;

import com.ggocodelab.program08.entities.Department;

public class DepartmentDTO {
	
	private Long id;
	private String name;
	
	public DepartmentDTO() {}
	
	public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
		
	}
	public DepartmentDTO(Department entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
