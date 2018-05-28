package com.salesianostriana.mario.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
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

	@Autowired
	AppointmentService appointmentService;

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
		Employee deletedEmployee = findOne(employee.getId());
		if (deletedEmployee != null)
			companyService.findDefaultCompany().removeEmployee(employee);
		repository.delete(employee);
		return deletedEmployee;
	}

	public void setHistoricalTrue(Employee employee) {
		employee.setHistorical(true);
		employee.setHistoricalDate(LocalDateTime.now());
		// Por cada cita de ese empleado, setea a nulo su atributo empleado si la cita
		// es después de la fecha en la que se ha eliminado (hecho histórico) al
		// empleado.
		employee.getAppointments().forEach((a) -> {
			if (a.getStartTime().isAfter(a.getEmployee().getHistoricalDate())) {
				a.setEmployee(null);
			}
		});
		edit(employee);
	}

	public void edit(Employee entidad) {
		// TODO: Implement this because on edit they disappear on edit.
		// entidad.setAppointments(oldAppointments);
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
	
	public Iterable<Employee> findAllHistorical() {
		return repository.findByHistoricalTrue();
	}

	public long calculateNumberOfActiveEmployees() {
		return findAllActive().spliterator().getExactSizeIfKnown();
	}

	public Employee findFirstAvailableByDateTime(LocalDateTime appointmentDateTime) {
		List<Employee> employees = StreamSupport.stream(findAllActive().spliterator(), false)
				.collect(Collectors.toList());
		Employee firstAvailableEmployee;
		Appointment appointmentOnSelectedTime = appointmentService.findOneByStartTime(appointmentDateTime);

		if (appointmentOnSelectedTime == null) {
			firstAvailableEmployee = employees.stream().findFirst().orElse(null);
		} else {
			firstAvailableEmployee = employees.stream()
					.filter((employee) -> (!employee.equals(appointmentOnSelectedTime.getEmployee()))).findFirst()
					.orElse(null);
		}

		return firstAvailableEmployee;
	}

}
