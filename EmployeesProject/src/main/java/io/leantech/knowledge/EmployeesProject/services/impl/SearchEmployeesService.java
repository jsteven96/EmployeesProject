package io.leantech.knowledge.EmployeesProject.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;
import io.leantech.knowledge.EmployeesProject.entities.Employee;
import io.leantech.knowledge.EmployeesProject.repositories.EmployeeRepository;
import io.leantech.knowledge.EmployeesProject.services.SearchEmployeesServiceI;

@Service
public class SearchEmployeesService implements SearchEmployeesServiceI {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<BasicEmployeeDTO> searchEmployees(String positionName, String employeName) {
		List<Employee> resultado = new ArrayList<>();
		List<BasicEmployeeDTO> retorno = new ArrayList<>();

		if(positionName != null && !positionName.isEmpty()) {
			resultado = employeeRepository.findAllByPosition_NameLike("%" +positionName + "%");
		} else if(employeName != null && !employeName.isEmpty()) {
			resultado = employeeRepository.findAllByCandidate_NameLike("%" + employeName + "%");
		} else {
			resultado = employeeRepository.findAll();
		}

		retorno = basicEmployeeListGenerate(resultado);		
		return retorno;
	}
	
	private List<BasicEmployeeDTO> basicEmployeeListGenerate(List<Employee> base){
		return base.stream().map(elemento -> basicEmployeeGenerate(elemento)).collect(Collectors.toList());
	}
	
	private BasicEmployeeDTO basicEmployeeGenerate(Employee employee) {
		BasicEmployeeDTO basicEmployee = new BasicEmployeeDTO();
		basicEmployee.setId(employee.getId());
		basicEmployee.setSalary(employee.getSalary());
		basicEmployee.setName(employee.getCandidate().getName());
		basicEmployee.setLastName(employee.getCandidate().getLastName());
		basicEmployee.setAddress(employee.getCandidate().getAddress());
		basicEmployee.setCellphone(employee.getCandidate().getCellphone());
		basicEmployee.setCityName(employee.getCandidate().getCityName());
		basicEmployee.setPosition(employee.getPosition().getName());
		
		return basicEmployee;
	}
}
