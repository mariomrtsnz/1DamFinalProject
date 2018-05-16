package com.salesianostriana.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.b2b.repo.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repositorio;
}
