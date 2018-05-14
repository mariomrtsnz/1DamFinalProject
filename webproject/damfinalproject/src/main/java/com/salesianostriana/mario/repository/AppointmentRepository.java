package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.mario.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
