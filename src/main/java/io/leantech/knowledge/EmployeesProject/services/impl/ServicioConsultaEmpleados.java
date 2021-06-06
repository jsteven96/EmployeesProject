package io.leantech.knowledge.EmployeesProject.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.dtos.EmpleadoDTO;
import io.leantech.knowledge.EmployeesProject.entities.Employee;
import io.leantech.knowledge.EmployeesProject.repositories.EmployeeRepository;
import io.leantech.knowledge.EmployeesProject.services.ServicioConsultaEmpleadosI;

@Service
public class ServicioConsultaEmpleados implements ServicioConsultaEmpleadosI {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmpleadoDTO> consultarEmpleados(String posicion, String nombre) {
		List<Employee> resultado = new ArrayList<>();
		List<EmpleadoDTO> retorno = new ArrayList<>();

		if(posicion != null && !posicion.isEmpty()) {
			resultado = employeeRepository.findAllByPosition_NameLike("%" +posicion + "%");
		} else if(nombre != null && !nombre.isEmpty()) {
			resultado = employeeRepository.findAllByCandidate_NameLike("%" + nombre + "%");
		} else {
			resultado = employeeRepository.findAll();
		}

		retorno = convertidor(resultado);		
		return retorno;
	}
	
	private List<EmpleadoDTO> convertidor(List<Employee> base){
		return base.stream().map(elemento -> traducir(elemento)).collect(Collectors.toList());
	}
	
	private EmpleadoDTO traducir(Employee raiz) {
		EmpleadoDTO empleado = new EmpleadoDTO();
		empleado.setId(raiz.getId());
		empleado.setPersonName(raiz.getCandidate().getName() + " " + raiz.getCandidate().getLastName());
		empleado.setPositionName(raiz.getPosition().getName());
		empleado.setSalary(raiz.getSalary());
		return empleado;
	}
}
