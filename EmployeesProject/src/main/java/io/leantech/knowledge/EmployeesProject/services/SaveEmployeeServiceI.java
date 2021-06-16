package io.leantech.knowledge.EmployeesProject.services;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;
import io.leantech.knowledge.EmployeesProject.exceptions.EmployeeNotFoundException;
import io.leantech.knowledge.EmployeesProject.exceptions.PositionNotFoundException;

public interface SaveEmployeeServiceI {
	public BasicEmployeeDTO saveEmployee(BasicEmployeeDTO basicEmployeeDTO) throws EmployeeNotFoundException, PositionNotFoundException;
}
