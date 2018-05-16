package com.salesianostriana.b2b.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.b2b.model.Distribuidor;

public interface DistribuidorRepository extends JpaRepository<Distribuidor, Long>{

	public Distribuidor findFirstByUsernameAndPass(String username, String pass);
}
