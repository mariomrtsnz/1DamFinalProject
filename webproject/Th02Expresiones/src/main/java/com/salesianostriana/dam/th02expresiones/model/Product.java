package com.salesianostriana.dam.th02expresiones.model;

import java.util.Calendar;

//Clase POJO normal

public class Product {

	private long id;//Mejor usar long para id que int, así evitamos dificultades con el tamaño de los mismos
	
	private String name;
	
	private String description;
	
	private double price;
	
	private boolean inStock = false;
	
	private Calendar date;
		

	public Product() {
		
	}

	public Product(long id, String name, String description, double price, boolean inStock, Calendar date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	/*Podemos aprender más de hashcode en los apuntes de la unidad 5, se suele usar cuando las 
	 * colecciones usadas en elprograma son Has, como será el caso de un carrito de la compra*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
}
