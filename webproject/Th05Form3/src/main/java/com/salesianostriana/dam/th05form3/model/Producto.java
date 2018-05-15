package com.salesianostriana.dam.th05form3.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Producto {

	private long id;

	private String name;

	private String description;

	private double price;
	
//Para la recogida de "datos" del boolean con radiobuttons, no usaremos este tipo, sino una lista de opciones tipo String
	//private boolean importacion;
	
	//Atributo para el tipo de cerveza que es. Aunque se trabajará con él usando radioButtons, 
	//lo usamos con tipo String que es lo que devuelven estos radios al ser marcados
	private String tipo;
	
	/*Ojo, el formato de la anotación debe ser inglés, años, mes y día.
	 * esta anotación es la que hace que la fecha recogida por el input tipo date
	 * pase al controlador y este la pase a tipo Date. En el controlador, podemos ver cómo
	 * se tienen en cuenta esta "validación" de datos, es decir, que no se admitan fechas con otro formato*/
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FCaducidad;

	public Producto() {
	}

	public Producto(long id, String name, String description, double price, String tipo, Date fCaducidad) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.tipo = tipo;
		FCaducidad = fCaducidad;
	}

	public Producto(long id, String name, String description, double price, String tipo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.tipo = tipo;

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

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Date getFCaducidad() {
		return FCaducidad;
	}

	public void setFCaducidad(Date fCaducidad) {
		FCaducidad = fCaducidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FCaducidad == null) ? 0 : FCaducidad.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Producto other = (Producto) obj;
		if (FCaducidad == null) {
			if (other.FCaducidad != null)
				return false;
		} else if (!FCaducidad.equals(other.FCaducidad))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}


}
