package com.salesianostriana.b2b.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Pedido {
	
	@GeneratedValue
	@Id
	private long id;
	
	private String fechaCompra;
	
	private String fechaLlegada;
	
	private double total;
	
	@OneToMany
	Set<LineaDePedido> lineasDePedido = new HashSet<>();
	
	@ManyToOne
	private Empresa empresa;

	//Constructor
	public Pedido() {
		
	};
	
	
	
	public Pedido(String fechaCompra, String fechaLlegada, double total, Set<LineaDePedido> lineasDePedido) {
		super();
		this.fechaCompra = fechaCompra;
		this.fechaLlegada = fechaLlegada;
		this.total = total;
		this.lineasDePedido = lineasDePedido;
	}






	public Pedido(long id, String fechaCompra, String fechaLlegada, double total, Set<LineaDePedido> lineasDePedido) {
		super();
		this.id = id;
		this.fechaCompra = fechaCompra;
		this.fechaLlegada = fechaLlegada;
		this.total = total;
		this.lineasDePedido = lineasDePedido;
	}


	//Getters And Setters
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getFechaCompra() {
		return fechaCompra;
	}



	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}



	public String getFechaLlegada() {
		return fechaLlegada;
	}



	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public Set<LineaDePedido> getLineasDePedido() {
		return lineasDePedido;
	}



	public void setLineasDePedido(Set<LineaDePedido> lineasDePedido) {
		this.lineasDePedido = lineasDePedido;
	}


	//toString
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaCompra=" + fechaCompra + ", fechaLlegada=" + fechaLlegada + ", total="
				+ total + ", lineasDePedido=" + lineasDePedido + "]";
	}



	
	//HashCode e Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
		result = prime * result + ((fechaLlegada == null) ? 0 : fechaLlegada.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lineasDePedido == null) ? 0 : lineasDePedido.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
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
		Pedido other = (Pedido) obj;
		if (fechaCompra == null) {
			if (other.fechaCompra != null)
				return false;
		} else if (!fechaCompra.equals(other.fechaCompra))
			return false;
		if (fechaLlegada == null) {
			if (other.fechaLlegada != null)
				return false;
		} else if (!fechaLlegada.equals(other.fechaLlegada))
			return false;
		if (id != other.id)
			return false;
		if (lineasDePedido == null) {
			if (other.lineasDePedido != null)
				return false;
		} else if (!lineasDePedido.equals(other.lineasDePedido))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	//Metodos Helper
}
