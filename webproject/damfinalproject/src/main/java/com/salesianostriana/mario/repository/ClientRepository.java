package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.mario.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
