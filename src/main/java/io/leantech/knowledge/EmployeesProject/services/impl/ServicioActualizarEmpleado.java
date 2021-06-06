package io.leantech.knowledge.EmployeesProject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import io.leantech.knowledge.EmployeesProject.dtos.EmpleadoDTO;
import io.leantech.knowledge.EmployeesProject.entities.Candidate;
import io.leantech.knowledge.EmployeesProject.entities.Employee;
import io.leantech.knowledge.EmployeesProject.entities.Position;
import io.leantech.knowledge.EmployeesProject.repositories.EmployeeRepository;
import io.leantech.knowledge.EmployeesProject.services.ServicioActualizarEmpleadoI;

public class ServicioActualizarEmpleado implements ServicioActualizarEmpleadoI{
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleado) {
		return null;
	}
	
	private Employee deEmpleadoAEmployee(EmpleadoDTO empleado) {
		Employee employee = new Employee();
		Candidate candidate = new Candidate();
		candidate.setName(empleado.getPersonName());
		candidate.setLastName(empleado.getPersonLastName());
		candidate.set
	}

}
