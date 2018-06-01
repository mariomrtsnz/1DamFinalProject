package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
	Iterable<Treatment> findByHistoricalTrue();
	Iterable<Treatment> findByHistoricalFalse();
	public Iterable<Treatment> findByNameContainingIgnoreCase(String nombre);
	Treatment findFirstByName(String name);
}
