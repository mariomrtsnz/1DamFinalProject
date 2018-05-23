package com.salesianostriana.mario.repository;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.model.Employee;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	Iterable<Appointment> findByPaidTrue();
	Appointment findByStartTime(LocalDateTime appointmentTime);
	Iterable<Appointment> findByEmployee(Employee employee);
}
