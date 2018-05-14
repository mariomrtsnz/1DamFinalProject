package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.mario.model.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
