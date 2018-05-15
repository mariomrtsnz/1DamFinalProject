package com.salesianostriana.dam.th04formularios2.repository;

import java.util.List;

import com.salesianostriana.dam.th04formularios2.model.Product;


/*Métodos DAO para el acceso a los datos necesarios del modelo, es decir, de la BBDD*/
public interface ProductRepository {

	public List<Product> findAll();
	
	public Product findById(long id);
	
	
}
