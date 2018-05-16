package com.salesianostriana.b2b.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.b2b.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	public Empresa findFirstByUsernameAndPass(String username, String pass);
}
