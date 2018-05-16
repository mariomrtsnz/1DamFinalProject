package com.salesianostriana.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.b2b.repo.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repositorio;
}
