package com.salesianostriana.mario.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.repository.AdminRepository;

@Service
public class AdminService {
	AdminRepository repository;

	public Admin save(Admin entidad) {
		return repository.save(entidad);
	}

	public void remove(Admin entidad) {
		repository.delete(entidad);
	}

	public void edit(Admin entidad) {
		remove(entidad);
		save(entidad);
	}
}
