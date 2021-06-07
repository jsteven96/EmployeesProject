package io.leantech.knowledge.EmployeesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;
import io.leantech.knowledge.EmployeesProject.services.ServicioActualizarEmpleadoI;
import io.leantech.knowledge.EmployeesProject.services.ServicioConsultaEmpleadosI;

@RestController
public class EmployeesController {
	
	@Autowired
	private ServicioConsultaEmpleadosI servicioConsultaEmpleados;
	
	@Autowired
	private ServicioActualizarEmpleadoI servicioActualizarEmpleado;
	
	@GetMapping("/employees")
	public ResponseEntity<List<BasicEmployeeDTO>> consultaEmpleados(
			@RequestParam(name = "name", required = false) String nombre,
			@RequestParam(name = "position", required = false) String posicion){
		
		List<BasicEmployeeDTO> resultado = servicioConsultaEmpleados.consultarEmpleados(posicion, nombre);
		return new ResponseEntity<List<BasicEmployeeDTO>>(resultado, HttpStatus.OK);	
	}
	
	@PostMapping("/employee")
	public ResponseEntity<BasicEmployeeDTO> guardarEmpleado(
			@RequestBody() BasicEmployeeDTO basicEmployee){
		servicioActualizarEmpleado.actualizarEmpleado(basicEmployee);
		return new ResponseEntity<BasicEmployeeDTO>(basicEmployee, HttpStatus.OK);
	}
	
}
