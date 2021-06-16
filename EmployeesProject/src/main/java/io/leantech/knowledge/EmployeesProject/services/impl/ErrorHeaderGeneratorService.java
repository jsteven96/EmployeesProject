package io.leantech.knowledge.EmployeesProject.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import io.leantech.knowledge.EmployeesProject.services.ErrorHeaderGeneratorServiceI;

@Service
public class ErrorHeaderGeneratorService implements ErrorHeaderGeneratorServiceI {
	
	@Value("${header.name}")
	private String headerName;
	
	@Override
	public HttpHeaders generateHeader(String error) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Expose-Headers", headerName);
		responseHeaders.set(headerName, error);
		return responseHeaders;
	}

}
