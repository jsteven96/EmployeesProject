package io.leantech.knowledge.EmployeesProject.services;

import java.util.List;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;

public interface SearchEmployeesServiceI {
	public List<BasicEmployeeDTO> searchEmployees(String positionName, String employeeName);
}
