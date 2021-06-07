package io.leantech.knowledge.EmployeesProject.services;

import java.util.List;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;

public interface ServicioConsultaEmpleadosI {
	public List<BasicEmployeeDTO> consultarEmpleados(String posicion, String nombre);
}
