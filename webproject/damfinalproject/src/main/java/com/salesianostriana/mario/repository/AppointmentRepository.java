package com.salesianostriana.mario.repository;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	Iterable<Appointment> findByPaidTrue();
//	Iterable<Appointment> findAllByStartTime(Predicate<Appointment> predicate);
	Appointment findByStartTime(LocalDateTime appointmentTime);
}
