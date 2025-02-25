package com.salesianostriana.mario.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	Iterable<Appointment> findByPaidTrue();
	
	@Query("select a from #{#entityName} a where a.paid = TRUE AND a.employee = ?1")
	Iterable<Appointment> findByAppointmentPaymentTrueAndEmployee(Employee employee);

	Appointment findByStartTime(LocalDateTime appointmentTime);
	
	Iterable<Appointment> findAllByStartTime(LocalDateTime appointmentTime);

	Iterable<Appointment> findByEmployee(Employee employee);
	
	Iterable<Appointment> findByClient(Client client);
}
