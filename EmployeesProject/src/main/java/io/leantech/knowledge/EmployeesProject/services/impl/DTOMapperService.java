package io.leantech.knowledge.EmployeesProject.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.dtos.CandidateDTO;
import io.leantech.knowledge.EmployeesProject.dtos.EmployeeDTO;
import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;
import io.leantech.knowledge.EmployeesProject.entities.Candidate;
import io.leantech.knowledge.EmployeesProject.entities.Employee;
import io.leantech.knowledge.EmployeesProject.entities.Position;
import io.leantech.knowledge.EmployeesProject.services.DTOMapperServiceI;

@Service
public class DTOMapperService implements DTOMapperServiceI {
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<EmployeeDTO> fromEmployeesToEmployeeDTOs(List<Employee> employees) {
		return employees.stream().map(employee -> fromEmployeeToEmployeeDTO(employee)).collect(Collectors.toList());
	}
	
	private EmployeeDTO fromEmployeeToEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		employeeDTO.setPerson(modelMapper.map(employee.getCandidate(), CandidateDTO.class));
		return employeeDTO;
	}

	@Override
	public List<CandidateDTO> fromCandidatesToCandidateDTOs(List<Candidate> candidates) {
		return candidates.stream().map(candidate -> modelMapper.map(candidate, CandidateDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<PositionDTO> fromPositionsToPositionDTOs(List<Position> positions) {
		return positions.stream().map(position -> fromPositionToPositionDTO(position)).collect(Collectors.toList());
	}
	
	private PositionDTO fromPositionToPositionDTO(Position position) {
		PositionDTO positionDTO = new PositionDTO();
		positionDTO = modelMapper.map(position, PositionDTO.class);
		positionDTO.setEmployees(fromEmployeesToEmployeeDTOs(position.getEmployees()));
		return positionDTO;
	}

}
