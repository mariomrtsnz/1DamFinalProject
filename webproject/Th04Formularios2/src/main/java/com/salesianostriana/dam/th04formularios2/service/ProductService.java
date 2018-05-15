package com.salesianostriana.dam.th04formularios2.service;

import java.util.List;

import com.salesianostriana.dam.th04formularios2.model.Product;

public interface ProductService {

	public List<Product> obtenerProductos();
	
	public Product obtenerUnProducto(long id);
	
}
