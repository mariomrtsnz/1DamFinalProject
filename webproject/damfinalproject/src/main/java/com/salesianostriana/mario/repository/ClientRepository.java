package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.mario.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select distinct c from Client c join fetch c.appointments where c.id = ?1")
	Client encuentraClientConFacturas(Long id);
}
