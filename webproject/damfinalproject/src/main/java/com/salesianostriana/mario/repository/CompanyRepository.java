package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
