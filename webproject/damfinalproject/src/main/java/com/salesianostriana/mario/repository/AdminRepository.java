package com.salesianostriana.mario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.mario.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
