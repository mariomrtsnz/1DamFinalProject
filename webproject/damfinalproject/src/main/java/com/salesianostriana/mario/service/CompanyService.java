package com.salesianostriana.mario.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.model.Company;
import com.salesianostriana.mario.repository.AdminRepository;
import com.salesianostriana.mario.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository repository;

	@Autowired
	AdminRepository adminRepository;

	@Transactional
	public Company save(Company entidad, Admin admin) {
		Company result = repository.save(entidad);
		admin.setCompany(entidad);
		adminRepository.save(admin);
		return result;
	}

	public Company add(Company entidad) {
		return repository.save(entidad);
	}

	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	public void remove(Company entidad) {
		repository.delete(entidad);
	}

	public Company findOneById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Company findDefaultCompany() {
		return repository.findById(Long.valueOf(1)).orElse(null);
	}

	// public void edit(Company entidad) {
	// remove(entidad);
	// save(entidad);
	// }

}
