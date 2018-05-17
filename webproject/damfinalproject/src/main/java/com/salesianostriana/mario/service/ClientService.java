package com.salesianostriana.mario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;

	@Autowired
	CompanyService companyService;

	public Client save(Client entidad) {
		entidad.setCompany(companyService.findDefaultCompany());
		return repository.save(entidad);
	}

	public Client findOne(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Iterable<Client> findAll() {
		return repository.findAll();
	}

	public Client remove(Client client) {
		Client deletedClient = repository.findById(client.getId()).orElse(null);
		if (deletedClient != null)
			repository.delete(client);
		return deletedClient;
	}

	public void edit(Client entidad) {
		remove(entidad);
		save(entidad);
	}

	public Client login(String email, String password) {
		return repository.findFirstByEmailAndPassword(email, password);
	}

}
