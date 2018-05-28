package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select distinct c from Client c join fetch c.appointments where c.id = ?1")
	Client findClientWithAppointments(Long id);

	Client findFirstByEmailAndPassword(String email, String password);
	
	Client findFirstByEmail(String email);
	
	Client findFirstByDni(String dni);

	Iterable<Client> findByHistoricalTrue();

	Iterable<Client> findByHistoricalFalse();

	Iterable<Client> findByDuePaymentTrue();
}
