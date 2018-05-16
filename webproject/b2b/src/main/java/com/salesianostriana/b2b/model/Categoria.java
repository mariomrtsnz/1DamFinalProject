package com.salesianostriana.b2b.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Categoria {

	@GeneratedValue
	@Id
	private long id;
	private String nombre;
	
	@OneToMany
	Set<Producto> lineasDeProducto= new HashSet<>();
	
	//Constructores
	public Categoria () {
		
	}
	
	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(String nombre, long id) {
		this.nombre = nombre;
		this.id = id;
	}

	//Getters And Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//toString
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", id=" + id + "]";
	}

	//HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lineasDeProducto == null) ? 0 : lineasDeProducto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		if (lineasDeProducto == null) {
			if (other.lineasDeProducto != null)
				return false;
		} else if (!lineasDeProducto.equals(other.lineasDeProducto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	//Metodos Helper
	
	
}
