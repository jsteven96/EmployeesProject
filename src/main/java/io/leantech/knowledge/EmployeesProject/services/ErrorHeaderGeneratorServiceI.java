package io.leantech.knowledge.EmployeesProject.services;

import org.springframework.http.HttpHeaders;

public interface ErrorHeaderGeneratorServiceI {
	public HttpHeaders generateHeader(String error);
}
