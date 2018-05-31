package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.mario.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findFirstByEmailAndPassword(String email, String password);
	Admin findFirstByEmail(String email);
}
