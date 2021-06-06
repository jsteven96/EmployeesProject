package io.leantech.knowledge.EmployeesProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.leantech.knowledge.EmployeesProject.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
