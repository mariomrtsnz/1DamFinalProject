package com.salesianostriana.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.b2b.model.Administrador;
import com.salesianostriana.b2b.repo.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	AdministradorRepository repositorio;
	
	public Administrador login(String username, String pass) {
		return repositorio.findFirstByUsernameAndPass(username, pass);
	}
	
	public Iterable<Administrador> findAll() {
		return repositorio.findAll();
	}
	
	public Administrador findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Administrador save(Administrador a) {
		return repositorio.save(a);
	}
	
	public Administrador edit(Administrador a) {
		return repositorio.save(a);
	}
	
	public Administrador delete(Administrador a) {
		Administrador aBorrar = repositorio.findById(a.getId()).orElse(null);
		if (aBorrar != null)
			repositorio.delete(a);
		
		return aBorrar;
	}
	
}
