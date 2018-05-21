package com.salesianostriana.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.b2b.model.Categoria;
import com.salesianostriana.b2b.repo.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repositorio;


	public Iterable <Categoria> findAll() {
		return repositorio.findAll();
	}
	
	public Categoria findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Categoria save(Categoria c) {
		return repositorio.save(c);
	}
	
	public Categoria edit(Categoria c) {
		return repositorio.save(c);
	}
	
	public Categoria delete(Categoria c) {
		Categoria aBorrar = repositorio.findById(c.getId()).orElse(null);
		if (aBorrar != null)
			repositorio.delete(c);
		
		return aBorrar;
	}
}
