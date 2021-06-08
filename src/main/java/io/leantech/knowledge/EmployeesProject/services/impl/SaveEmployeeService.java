package io.leantech.knowledge.EmployeesProject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;
import io.leantech.knowledge.EmployeesProject.entities.Candidate;
import io.leantech.knowledge.EmployeesProject.entities.Employee;
import io.leantech.knowledge.EmployeesProject.entities.Position;
import io.leantech.knowledge.EmployeesProject.exceptions.EmployeeNotFoundException;
import io.leantech.knowledge.EmployeesProject.exceptions.PositionNotFoundException;
import io.leantech.knowledge.EmployeesProject.repositories.EmployeeRepository;
import io.leantech.knowledge.EmployeesProject.repositories.PositionRepository;
import io.leantech.knowledge.EmployeesProject.services.SaveEmployeeServiceI;

@Service
public class SaveEmployeeService implements SaveEmployeeServiceI{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PositionRepository positionRepository;
	

	@Override
	public BasicEmployeeDTO saveEmployee(BasicEmployeeDTO basicEmployee) throws EmployeeNotFoundException, PositionNotFoundException {
		Employee employeeToSave;

		if(basicEmployee.getId() != null) {
			employeeToSave = employeeRepository.findById(basicEmployee.getId()).orElse(null);
			
			if(employeeToSave == null) {
				throw new EmployeeNotFoundException("Employee with id" + basicEmployee.getId() + " not found.");
			}
			
		} else {
			employeeToSave = new Employee();
		}

		fromBasicToEmployee(employeeToSave, basicEmployee);
		Position position = positionRepository.findByName(basicEmployee.getPosition());
		
		if (position != null) {
			employeeToSave.setPosition(position);
		} else {
			throw new PositionNotFoundException("Position called "+ basicEmployee.getPosition()+" not found.");
		}

		employeeToSave = employeeRepository.save(employeeToSave);
		basicEmployee.setId(employeeToSave.getId());
		return basicEmployee;
	}
	
	private void fromBasicToEmployee(Employee employee, BasicEmployeeDTO basicEmployee) {
		Candidate candidate = new Candidate();
		candidate.setName(basicEmployee.getName());
		candidate.setLastName(basicEmployee.getLastName());
		candidate.setAddress(basicEmployee.getAddress());
		candidate.setCellphone(basicEmployee.getCellphone());
		candidate.setCityName(basicEmployee.getCityName());
		employee.setCandidate(candidate);
		employee.setPosition(new Position(basicEmployee.getPosition()));
		employee.setSalary(basicEmployee.getSalary());
	}

}
