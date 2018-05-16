package com.salesianostriana.mario.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Company;
import com.salesianostriana.mario.repository.CompanyRepository;

@Service
public class CompanyService {
	CompanyRepository repository;

	public Company save(Company entidad) {
		return repository.save(entidad);
	}

	public void remove(Company entidad) {
		repository.delete(entidad);
	}

	public void edit(Company entidad) {
		remove(entidad);
		save(entidad);
	}
}
