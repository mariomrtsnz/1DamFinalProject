package com.salesianostriana.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.b2b.model.Producto;
import com.salesianostriana.b2b.repo.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository repositorio;
	
	public Iterable<Producto> findAll() {
		return repositorio.findAll();
	}
	
	public Producto findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Producto save(Producto p) {
		return repositorio.save(p);
	}
	
	public Producto edit(Producto p) {
		return repositorio.save(p);
	}
	
	public Producto delete(Producto p) {
		Producto aBorrar = repositorio.findById(p.getId()).orElse(null);
		if (aBorrar != null)
			repositorio.delete(p);
		
		return aBorrar;
	}
}
