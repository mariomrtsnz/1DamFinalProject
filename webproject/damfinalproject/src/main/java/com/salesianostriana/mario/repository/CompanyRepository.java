package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.mario.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
