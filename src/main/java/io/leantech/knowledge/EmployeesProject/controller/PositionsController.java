package io.leantech.knowledge.EmployeesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.leantech.knowledge.EmployeesProject.dtos.PositionDTO;
import io.leantech.knowledge.EmployeesProject.services.SearchPositionsServiceI;

@RestController
@RequestMapping("/api")
public class PositionsController {
	
	@Autowired
	SearchPositionsServiceI servicioConsultaCargos;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/positions")
	public ResponseEntity<List<PositionDTO>> getPositions(){
		return new ResponseEntity<List<PositionDTO>>(servicioConsultaCargos.searchPositions(), HttpStatus.OK);
	}
}
