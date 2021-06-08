package io.leantech.knowledge.EmployeesProject.services;

import io.leantech.knowledge.EmployeesProject.exceptions.EmployeeNotFoundException;

public interface DeleteEmployeeServiceI {
	public Integer deleteEmployee(Integer employeeId) throws EmployeeNotFoundException;
}
