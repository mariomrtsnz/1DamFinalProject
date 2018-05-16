package com.salesianostriana.b2b.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.b2b.model.Administrador;


public interface AdministradorRepository extends JpaRepository<Administrador, Long>{

	public Administrador findFirstByUsernameAndPass(String username, String pass);
}
