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
	
	public Iterable<Client> findAllHistoricalAndDuePayment() {
		return repository.findAllByHistoricalTrueAndDuePaymentTrue();
	}
	
	public Iterable<Client> findAllHistorical() {
		return repository.findByHistoricalTrue();
	}
	
	public Iterable<Client> findAllActive() {
		return repository.findByHistoricalFalse();
	}
	
	public Iterable<Client> findByDuePayment() {
		return repository.findByDuePaymentTrue();
	}
	
	public Client findFirstByEmailAndPassword(String email, String password) {
		return repository.findFirstByEmailAndPassword(email, password);
	}
	
	public Client findFirstByEmail(String email) {
		return repository.findFirstByEmail(email);
	}
	
	public Client findFirstByDni(String dni) {
		return repository.findFirstByDni(dni);
	}
	
	public Client findFirstByName(String name) {
		return repository.findFirstByName(name);
	}
	
	public Client remove(Client client) {
		Client deletedClient = repository.findById(client.getId()).orElse(null);
		if (deletedClient != null)
			repository.delete(client);
		return deletedClient;
	}
	
	public void setHistoricalTrue(Client client) {
		client.setHistorical(true);
		client.getAppointments().forEach((a) -> a.setClient(null));
		edit(client);
	}

	public void edit(Client entidad) {
		save(entidad);
	}

	public Client login(String email, String password) {
		return repository.findFirstByEmailAndPassword(email, password);
	}

	public long calculateNumberOfItems() {
		return findAll().spliterator().getExactSizeIfKnown();
	}

}
