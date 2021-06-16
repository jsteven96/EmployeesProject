package io.leantech.knowledge.EmployeesProject.dtos;

import java.util.List;

public class PositionDTO {
	private Integer id;
	private String name;
	private List<EmployeeDTO> employees;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EmployeeDTO> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}
}
