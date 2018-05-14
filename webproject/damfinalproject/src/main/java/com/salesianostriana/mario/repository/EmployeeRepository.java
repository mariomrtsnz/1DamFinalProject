package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.mario.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
