package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findFirstByEmailAndPassword(String email, String password);
	Employee findFirstByEmail(String email);
	Iterable<Employee> findByHistoricalFalse();
	Iterable<Employee> findByHistoricalTrue();
	Employee findFirstByName(String name);
}
