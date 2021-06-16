package io.leantech.knowledge.EmployeesProject.dtos;

public class EmployeeDTO {
	private Integer id;
	private Long salary;
	private CandidateDTO person;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public CandidateDTO getPerson() {
		return person;
	}
	
	public void setPerson(CandidateDTO person) {
		this.person = person;
	}
	
	public Long getSalary() {
		return salary;
	}
	
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
