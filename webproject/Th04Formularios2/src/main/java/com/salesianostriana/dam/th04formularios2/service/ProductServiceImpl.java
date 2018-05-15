package com.salesianostriana.dam.th04formularios2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.th04formularios2.model.Product;
import com.salesianostriana.dam.th04formularios2.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{

	
	/*"Enlazado automáticamente con el repository repo. Este objeto repo, por ser de esa clase (de ese tipo) 
	 * puede llamar al método findAll o findById de la clase ProductRepositoryImpl y 
	 * nos devolverá todos los productos o uno en concreto buscado por id.
	 * Los métodos del service y del repository son los mismos en este ejemplo, pero en general no serán
	 * iguales, para resaltar esto, se le ha cambiado el nombre a los buscar (en español e inglés)*/
	
	
	@Autowired
	private ProductRepository repo;
	
	
	public List<Product> obtenerProductos() {
		return repo.findAll();
	}
	
	public Product obtenerUnProducto(long id) {
		return repo.findById(id);
	}
	
}
