package com.salesianostriana.mario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;

	public Client save(Client entidad) {
		return repository.save(entidad);
	}

	public Client findOne(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Iterable<Client> findAll() {
		return repository.findAll();
	}

	public void remove(Client entidad) {
		repository.delete(entidad);
	}

	public void edit(Client entidad) {
		remove(entidad);
		save(entidad);
	}

}
