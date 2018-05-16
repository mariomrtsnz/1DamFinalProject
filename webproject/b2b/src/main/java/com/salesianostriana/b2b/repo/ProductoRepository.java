package com.salesianostriana.b2b.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.b2b.model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
