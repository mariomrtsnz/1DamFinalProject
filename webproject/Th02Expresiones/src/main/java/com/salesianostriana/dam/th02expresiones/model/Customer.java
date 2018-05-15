package com.salesianostriana.dam.th02expresiones.model;

//Clase POJO normal 

public class Customer {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String genero;
	private long id;
	
	public Customer(String nombre, String apellido1, String apellido2, String genero, long id) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.genero = genero;
		this.id = id;
	}

	public Customer() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", genero="
				+ genero + ", id=" + id + "]";
	}
	
	
}
