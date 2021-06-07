package io.leantech.knowledge.EmployeesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;
import io.leantech.knowledge.EmployeesProject.services.ServicioConsultaCargosI;

@RestController
public class PositionsController {
	
	@Autowired
	ServicioConsultaCargosI servicioConsultaCargos;
	
	@GetMapping("/positions")
	public ResponseEntity<List<PositionDTO>> consultarCargos(){
		return new ResponseEntity<List<PositionDTO>>(servicioConsultaCargos.consultarCargos(), HttpStatus.OK);
	}
}
