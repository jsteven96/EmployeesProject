package io.leantech.knowledge.EmployeesProject.services;

import java.util.List;

import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;

public interface ServicioConsultaCargosI {
	public List<PositionDTO> consultarCargos();
}
