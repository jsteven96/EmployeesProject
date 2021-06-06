package io.leantech.knowledge.EmployeesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.leantech.knowledge.EmployeesProject.dtos.EmpleadoDTO;
import io.leantech.knowledge.EmployeesProject.services.ServicioConsultaEmpleadosI;

@RestController
public class EmployeesController {
	
	@Autowired
	private ServicioConsultaEmpleadosI servicioConsultaEmpleados;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmpleadoDTO>> consultaEmpleados(
			@RequestParam(name = "name", required = false) String nombre,
			@RequestParam(name = "position", required = false) String posicion){
		
		List<EmpleadoDTO> resultado = servicioConsultaEmpleados.consultarEmpleados(posicion, nombre);
		return new ResponseEntity<List<EmpleadoDTO>>(resultado, HttpStatus.OK);	
	}
}
