package io.leantech.knowledge.EmployeesProject.services;

import java.util.List;

import io.leantech.knowledge.EmployeesProject.dtos.EmpleadoDTO;

public interface ServicioConsultaEmpleadosI {
	public List<EmpleadoDTO> consultarEmpleados(String posicion, String nombre);
}
