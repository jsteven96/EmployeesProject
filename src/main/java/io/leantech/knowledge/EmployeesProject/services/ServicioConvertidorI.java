package io.leantech.knowledge.EmployeesProject.services;

import java.util.List;

import io.leantech.knowledge.EmployeesProject.dtos.CandidateDTO;
import io.leantech.knowledge.EmployeesProject.dtos.EmployeeDTO;
import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;
import io.leantech.knowledge.EmployeesProject.entities.Candidate;
import io.leantech.knowledge.EmployeesProject.entities.Employee;
import io.leantech.knowledge.EmployeesProject.entities.Position;

public interface ServicioConvertidorI {
	public List<EmployeeDTO> fromEmployeesToEmployeeDTOs(List<Employee> employees);
	public List<CandidateDTO> fromCandidatesToCandidateDTOs(List<Candidate> candidates);
	public List<PositionDTO> fromPositionsToPositionDTOs(List<Position> positions);
}
