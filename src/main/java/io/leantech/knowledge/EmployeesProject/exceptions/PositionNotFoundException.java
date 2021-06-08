package io.leantech.knowledge.EmployeesProject.exceptions;

public class PositionNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PositionNotFoundException(){
	}
	
	public PositionNotFoundException(String message){
		super(message);
	}
}
