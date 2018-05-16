package com.salesianostriana.b2b.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class LineaDePedido {

	@GeneratedValue
	@Id
	private long id;
	private int cantidad;
	private double total;
	
	
	/*@OneToMany
	(mappedBy="lineaPedido", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	Producto producto = new Producto();*/
	@ManyToOne
	private Producto producto;
	
	
	@ManyToOne
	private Pedido pedido;
	
	
	
	//Constructores
	public LineaDePedido () {
		
	}
	public LineaDePedido(int cantidad, Producto producto, double total) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.total = total;
	}
	
	
	public LineaDePedido(int cantidad, Producto producto, double total, Pedido pedido) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.total = total;
		this.pedido = pedido;
	}
	public LineaDePedido(long id, int cantidad, Producto producto, double total, Pedido pedido) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.total = total;
		this.pedido = pedido;
	}
	//Getters and Setters
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	//toString 
	@Override
	public String toString() {
		return "LineaDePedido [cantidad=" + cantidad + ", producto=" + producto + ", total=" + total + "]";
	}
	
	//HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		LineaDePedido other = (LineaDePedido) obj;
		if (cantidad != other.cantidad)
			return false;
		if (id != other.id)
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	//Metodos Helper
	
}
