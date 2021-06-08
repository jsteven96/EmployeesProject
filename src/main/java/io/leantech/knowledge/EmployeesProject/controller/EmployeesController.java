package io.leantech.knowledge.EmployeesProject.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;
import io.leantech.knowledge.EmployeesProject.exceptions.EmployeeNotFoundException;
import io.leantech.knowledge.EmployeesProject.exceptions.PositionNotFoundException;
import io.leantech.knowledge.EmployeesProject.services.DeleteEmployeeServiceI;
import io.leantech.knowledge.EmployeesProject.services.ErrorHeaderGeneratorServiceI;
import io.leantech.knowledge.EmployeesProject.services.SaveEmployeeServiceI;
import io.leantech.knowledge.EmployeesProject.services.SearchEmployeesServiceI;

@RestController
@RequestMapping("/api")
public class EmployeesController {
	
	@Autowired
	private SearchEmployeesServiceI searchEmployeesService;
	
	@Autowired
	private SaveEmployeeServiceI saveEmployeeService;
	
	@Autowired
	private DeleteEmployeeServiceI deleteEmployeeService;
	
	@Autowired
	private ErrorHeaderGeneratorServiceI errorHeaderGenerator;
	
	private Logger logger = LogManager.getLogger(EmployeesController.class);
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/employees")
	public ResponseEntity<List<BasicEmployeeDTO>> getEmployees(
			@RequestParam(name = "name", required = false) String nombre,
			@RequestParam(name = "position", required = false) String posicion){
		
		List<BasicEmployeeDTO> resultado = searchEmployeesService.searchEmployees(posicion, nombre);
		return new ResponseEntity<List<BasicEmployeeDTO>>(resultado, HttpStatus.OK);	
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/employees")
	public ResponseEntity<BasicEmployeeDTO> saveEmployee(
			@RequestBody() BasicEmployeeDTO basicEmployee){
		try {
			return ResponseEntity.ok(saveEmployeeService.saveEmployee(basicEmployee));
		} catch (EmployeeNotFoundException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();
		} catch (PositionNotFoundException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();	
		} catch (Exception e) {
			logger.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();
		}	
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/employees/{employeeId}")
	public ResponseEntity<BasicEmployeeDTO> updateEmployee(
			@RequestBody() BasicEmployeeDTO basicEmployee,
			@PathVariable("employeeId") Integer employeeId){
		basicEmployee.setId(employeeId);
		try {
			return ResponseEntity.ok(saveEmployeeService.saveEmployee(basicEmployee));
		} catch (EmployeeNotFoundException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();
		} catch (PositionNotFoundException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();
		} catch (Exception e) {
			logger.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();
		}	
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<Integer> deleteEmployee(
			@PathVariable("employeeId") Integer employeeId){
		try {
			return ResponseEntity.ok(deleteEmployeeService.deleteEmployee(employeeId));
		} catch (EmployeeNotFoundException e) {
			logger.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();
		} catch (Exception e) {
			logger.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(errorHeaderGenerator.generateHeader(e.getMessage())).build();
		}	
	}
}
