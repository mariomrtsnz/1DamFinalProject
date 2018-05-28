package com.salesianostriana.mario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository repository;

	@Autowired
	CompanyService companyService;

	public Admin save(Admin admin) {
		admin.setCompany(companyService.findDefaultCompany());
		return repository.save(admin);
	}

	public Admin remove(Admin admin) {
		Admin deletedAdmin = repository.findById(admin.getId()).orElse(null);
		if (deletedAdmin != null)
			repository.delete(admin);
		return deletedAdmin;
	}

	public void edit(Admin entidad) {
		remove(entidad);
		save(entidad);
	}

	public Admin login(String email, String password) {
		return repository.findFirstByEmailAndPassword(email, password);
	}

	public Iterable<Admin> findAll() {
		return repository.findAll();
	}

	public Admin findOneById(Long id) {
		return repository.findById(id).orElse(null);
	}
}
