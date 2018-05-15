package com.salesianostriana.dam.th04formularios2.model;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

//Clase POJO modelo. En este caso vamos a usar fechas, con la clase LocalDate
//Y los productos son cervezas 

public class Product {
	
	private long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private boolean importacion;
	
	private LocalDate FCaducidad;
	
	private String imagen;
		
	public Product() { }

	public Product(long id, String name, String description, double price, boolean importacion, LocalDate fCaducidad, String imagen) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.importacion = importacion;
		this.FCaducidad = fCaducidad;
		this.imagen=imagen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isImportacion() {
		return importacion;
	}

	public void setImportacion(boolean importacion) {
		this.importacion = importacion;
	}



	public LocalDate getFCaducidad() {
		return FCaducidad;
	}

	public void setFCaducidad(LocalDate fCaducidad) {
		FCaducidad = fCaducidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	

	

	

	
	
	
}
