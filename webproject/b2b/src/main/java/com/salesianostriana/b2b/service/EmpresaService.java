package com.salesianostriana.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.b2b.model.Empresa;
import com.salesianostriana.b2b.repo.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository repositorio;
	
	public Empresa login(String username, String pass) {
		return repositorio.findFirstByUsernameAndPass(username, pass);
	}
	
	public Iterable<Empresa> findAll() {
		return repositorio.findAll();
	}
	
	public Empresa findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Empresa save(Empresa e) {
		return repositorio.save(e);
	}
	
	public Empresa edit(Empresa e) {
		return repositorio.save(e);
	}
	
	public Empresa delete(Empresa e) {
		Empresa aBorrar = repositorio.findById(e.getIdEmpresa()).orElse(null);
		if (aBorrar != null)
			repositorio.delete(e);
		
		return aBorrar;
	}
}
