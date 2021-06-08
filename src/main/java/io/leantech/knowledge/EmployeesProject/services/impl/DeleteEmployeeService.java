package io.leantech.knowledge.EmployeesProject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.exceptions.EmployeeNotFoundException;
import io.leantech.knowledge.EmployeesProject.repositories.EmployeeRepository;
import io.leantech.knowledge.EmployeesProject.services.DeleteEmployeeServiceI;

@Service
public class DeleteEmployeeService implements DeleteEmployeeServiceI {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Integer deleteEmployee(Integer employeeId) throws EmployeeNotFoundException {
		if(employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
		} else {
			throw new EmployeeNotFoundException("Employee with id "+ employeeId+" not found.");
		}
		return employeeId;
	}

}
