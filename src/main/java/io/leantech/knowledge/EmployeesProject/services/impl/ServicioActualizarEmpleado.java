package io.leantech.knowledge.EmployeesProject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;
import io.leantech.knowledge.EmployeesProject.entities.Candidate;
import io.leantech.knowledge.EmployeesProject.entities.Employee;
import io.leantech.knowledge.EmployeesProject.entities.Position;
import io.leantech.knowledge.EmployeesProject.repositories.EmployeeRepository;
import io.leantech.knowledge.EmployeesProject.repositories.PositionRepository;
import io.leantech.knowledge.EmployeesProject.services.ServicioActualizarEmpleadoI;

@Service
public class ServicioActualizarEmpleado implements ServicioActualizarEmpleadoI{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PositionRepository positionRepository;
	

	@Override
	public BasicEmployeeDTO actualizarEmpleado(BasicEmployeeDTO basicEmployee) {
		Employee employeeToSave = new Employee();
		employeeToSave = fromBasicToEmployee(basicEmployee);
		Position position = positionRepository.findByName(basicEmployee.getPosition());
		if (position != null) {
			employeeToSave.setPosition(position);
		}
		employeeToSave = employeeRepository.save(employeeToSave);
		basicEmployee.setId(employeeToSave.getId());
		return basicEmployee;
	}
	
	private Employee fromBasicToEmployee(BasicEmployeeDTO basicEmployee) {
		Employee employee = new Employee();
		Candidate candidate = new Candidate();
		candidate.setName(basicEmployee.getName());
		candidate.setLastName(basicEmployee.getLastName());
		candidate.setAddress(basicEmployee.getAddress());
		candidate.setCellphone(basicEmployee.getCellphone());
		candidate.setCityName(basicEmployee.getCityName());
		employee.setCandidate(candidate);
		employee.setPosition(new Position(basicEmployee.getPosition()));
		employee.setSalary(basicEmployee.getSalary());
		return employee;
	}

}
