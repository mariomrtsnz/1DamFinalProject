package com.salesianostriana.mario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.salesianostriana.mario.model.Treatment;

public interface TreatmentServiceI {
	Page<Treatment> findAllPageable(Pageable pageable);
}
