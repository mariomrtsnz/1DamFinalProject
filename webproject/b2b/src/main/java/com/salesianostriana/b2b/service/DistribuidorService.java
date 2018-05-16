package com.salesianostriana.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.b2b.model.Distribuidor;
import com.salesianostriana.b2b.repo.DistribuidorRepository;

@Service
public class DistribuidorService {

	@Autowired
	DistribuidorRepository repositorio;
	
	public Distribuidor login(String username, String pass) {
		return repositorio.findFirstByUsernameAndPass(username, pass);
	}
	
	public Iterable<Distribuidor> findAll() {
		return repositorio.findAll();
	}
	
	public Distribuidor findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Distribuidor save(Distribuidor d) {
		return repositorio.save(d);
	}
	
	public Distribuidor edit(Distribuidor d) {
		return repositorio.save(d);
	}
	
	public Distribuidor delete(Distribuidor d) {
		Distribuidor aBorrar = repositorio.findById(d.getIdDistribuidor()).orElse(null);
		if (aBorrar != null)
			repositorio.delete(d);
		
		return aBorrar;
	}
	
}
