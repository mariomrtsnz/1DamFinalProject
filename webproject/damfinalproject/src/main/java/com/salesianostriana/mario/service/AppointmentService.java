package com.salesianostriana.mario.service;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository repository;

	public Appointment findOne(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Iterable<Appointment> findAll() {
		return repository.findAll();
	}

	public Appointment save(Appointment entidad) {
		return repository.save(entidad);
	}

	public void remove(Appointment entidad) {
		repository.delete(entidad);
	}

	public void edit(Appointment entidad) {
		remove(entidad);
		save(entidad);
	}
	
	public Iterable<Appointment> findAllPaid() {
		return repository.findByPaidTrue();
	}
	
	public long calculateNumberOfPaidAppointments() {
		return findAllPaid().spliterator().getExactSizeIfKnown();
	}
	
	public Appointment findOneByStartTime(LocalDateTime appointmentTime) {
		return repository.findByStartTime(appointmentTime);
	}

}
