package io.leantech.knowledge.EmployeesProject.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;
import io.leantech.knowledge.EmployeesProject.repositories.PositionRepository;
import io.leantech.knowledge.EmployeesProject.services.SearchPositionsServiceI;
import io.leantech.knowledge.EmployeesProject.services.DTOMapperServiceI;

@Service
public class SearchPositionsService implements SearchPositionsServiceI {
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	DTOMapperServiceI servicioConvertidor;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<PositionDTO> searchPositions() {
		return servicioConvertidor.fromPositionsToPositionDTOs(positionRepository.findAll());
	}
	
}
