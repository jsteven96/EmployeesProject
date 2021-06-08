package io.leantech.knowledge.EmployeesProject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import io.leantech.knowledge.EmployeesProject.dtos.BasicEmployeeDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeesController.class)
public class EmployeesControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeesController employeesController;
	
	@Test
	public void getEmployeesTest() throws Exception {
		BasicEmployeeDTO basicEmployee = new BasicEmployeeDTO();
		basicEmployee.setId(1);
		basicEmployee.setName("Name");
		basicEmployee.setLastName("LastName");
		basicEmployee.setPosition("Developer");
		basicEmployee.setSalary(230000L);
		basicEmployee.setAddress("Address");
		List<BasicEmployeeDTO> allEmployees = new ArrayList<BasicEmployeeDTO>();
		allEmployees.add(basicEmployee);
		given(employeesController.getEmployees(null, null)).willReturn(new ResponseEntity<List<BasicEmployeeDTO>>(allEmployees, HttpStatus.OK));
		mvc.perform(get("http://localhost:8083/api/employees")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(basicEmployee.getName())));		
	}
	
	@Test
	public void saveEmployeeTest() throws Exception {
		
		String jsonBody = "{"
				+ "    \"salary\": 230000,\r\n"
				+ "    \"name\": \"Name\",\r\n"
				+ "    \"lastName\": \"LastName\",\r\n"
				+ "    \"address\": \"Address\",\r\n"
				+ "    \"cellphone\": \"cellPhone\",\r\n"
				+ "    \"cityName\": \"cityName\",\r\n"
				+ "    \"position\": \"Developer\""
				+ "}";
		BasicEmployeeDTO basicEmployee = new BasicEmployeeDTO();
		basicEmployee.setId(1);
		basicEmployee.setName("Name");
		basicEmployee.setLastName("LastName");
		basicEmployee.setPosition("Developer");
		basicEmployee.setSalary(230000L);
		basicEmployee.setAddress("Address");
		given(employeesController.saveEmployee(basicEmployee)).willReturn(new ResponseEntity<BasicEmployeeDTO>(basicEmployee, HttpStatus.OK));
		mvc.perform(post("http://localhost:8083/api/employees")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
