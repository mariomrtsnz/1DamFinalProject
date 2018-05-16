package com.salesianostriana.b2b.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.b2b.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	
}
