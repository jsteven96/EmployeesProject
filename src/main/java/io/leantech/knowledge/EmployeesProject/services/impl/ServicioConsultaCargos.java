package io.leantech.knowledge.EmployeesProject.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;
import io.leantech.knowledge.EmployeesProject.repositories.PositionRepository;
import io.leantech.knowledge.EmployeesProject.services.ServicioConsultaCargosI;
import io.leantech.knowledge.EmployeesProject.services.ServicioConvertidorI;

@Service
public class ServicioConsultaCargos implements ServicioConsultaCargosI {
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	ServicioConvertidorI servicioConvertidor;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<PositionDTO> consultarCargos() {
		return servicioConvertidor.fromPositionsToPositionDTOs(positionRepository.findAll());
	}
	
}
