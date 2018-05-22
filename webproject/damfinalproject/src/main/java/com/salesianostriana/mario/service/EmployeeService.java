package com.salesianostriana.mario.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	CompanyService companyService;

	public Employee findOne(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Iterable<Employee> findAll() {
		return repository.findAll();
	}

	public Employee save(Employee entidad) {
		entidad.setCompany(companyService.findDefaultCompany());
		return repository.save(entidad);
	}

	public Employee remove(Employee employee) {
		Employee deletedEmployee = repository.findById(employee.getId()).orElse(null);
		if (deletedEmployee != null)
			repository.delete(employee);
		return deletedEmployee;
	}

	public void edit(Employee entidad) {
		remove(entidad);
		save(entidad);
	}

	public Employee login(String email, String password) {
		return repository.findFirstByEmailAndPassword(email, password);
	}
	
	public long calculateNumberOfItems() {
		return findAll().spliterator().getExactSizeIfKnown();
	}
	
	public Iterable<Employee> findAllActive() {
		
		return repository.findByHistoricalFalse();
	}
	
	public long calculateNumberOfActiveEmployees() {
		return findAllActive().spliterator().getExactSizeIfKnown();
	}
	
	public Employee findFirstAvailableByDateTime(LocalDateTime ldt) {
		List<Employee> employees = StreamSupport.stream(findAllActive().spliterator(), false).collect(Collectors.toList());
		
		Predicate<Appointment> appointmentPredicate = (a) -> a.getStartTime() == ldt;
		
		Predicate<Employee> employeePredicate = (e) -> e.getAppointments().stream().filter(appointmentPredicate);

		Employee firstEmployee = employees.stream().filter(employeePredicate).findFirst().orElse(null);
		
		return firstEmployee;
	}

}
