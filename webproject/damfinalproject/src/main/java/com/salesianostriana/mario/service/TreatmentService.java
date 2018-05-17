package com.salesianostriana.mario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.repository.TreatmentRepository;

@Service
public class TreatmentService {

	@Autowired
	TreatmentRepository repository;
	
	@Autowired
	CompanyService companyService;

	public Treatment findOneById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Iterable<Treatment> findAll() {
		return repository.findAll();
	}

	public Treatment save(Treatment entidad) {
		entidad.setCompany(companyService.findDefaultCompany());
		return repository.save(entidad);
	}

	public void remove(Treatment entidad) {
		repository.delete(entidad);
	}

	public void edit(Treatment entidad) {
		remove(entidad);
		save(entidad);
	}

}
