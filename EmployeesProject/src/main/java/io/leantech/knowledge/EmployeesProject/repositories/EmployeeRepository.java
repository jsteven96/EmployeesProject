package io.leantech.knowledge.EmployeesProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.leantech.knowledge.EmployeesProject.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findAllByCandidate_NameLike(String nombre);
	public List<Employee> findAllByPosition_NameLike(String posicion);
	

}
