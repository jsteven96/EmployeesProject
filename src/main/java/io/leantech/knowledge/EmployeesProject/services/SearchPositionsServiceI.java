package io.leantech.knowledge.EmployeesProject.services;

import java.util.List;

import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;

public interface SearchPositionsServiceI {
	public List<PositionDTO> searchPositions();
}
