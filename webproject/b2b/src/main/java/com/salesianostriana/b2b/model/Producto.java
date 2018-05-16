package com.salesianostriana.b2b.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Producto {
	
	@GeneratedValue
	@Id
	private long id;
	
	private String nombre;
	private long sku;
	private int unidades;
	private double precio;
	private String descripcion;
	private String imagen;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Distribuidor distribuidor;
	

	@OneToMany
	Set<LineaDePedido> listaLineaP= new HashSet<>();

	//Constructores
	
	public Producto () {
		
	};

	public Producto(long id, String nombre, long sku, int unidades, double precio, String descripcion, String imagen,
			Categoria categoria, Distribuidor distribuidor, Set<LineaDePedido> listaLineaP) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sku = sku;
		this.unidades = unidades;
		this.precio = precio;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.categoria = categoria;
		this.distribuidor = distribuidor;
		this.listaLineaP = listaLineaP;
	}


	public Producto(String nombre, long sku, int unidades, double precio, String descripcion, String imagen,
			Categoria categoria, Distribuidor distribuidor, Set<LineaDePedido> listaLineaP) {
		super();
		this.nombre = nombre;
		this.sku = sku;
		this.unidades = unidades;
		this.precio = precio;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.categoria = categoria;
		this.distribuidor = distribuidor;
		this.listaLineaP = listaLineaP;
	}


	public Producto(String nombre, long sku, int unidades, double precio, String descripcion, String imagen,
			Categoria categoria, Distribuidor distribuidor) {
		super();
		this.nombre = nombre;
		this.sku = sku;
		this.unidades = unidades;
		this.precio = precio;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.categoria = categoria;
		this.distribuidor = distribuidor;
	}

	//Getters and Setters
	
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

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public Set<LineaDePedido> getListaLineaP() {
		return listaLineaP;
	}

	public void setListaLineaP(Set<LineaDePedido> listaLineaP) {
		this.listaLineaP = listaLineaP;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", sku=" + sku + ", unidades=" + unidades + ", precio="
				+ precio + ", descripcion=" + descripcion + ", imagen=" + imagen + ", categoria=" + categoria
				+ ", distribuidor=" + distribuidor + ", listaLineaP=" + listaLineaP + "]";
	}
	
	//HashCode And Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((distribuidor == null) ? 0 : distribuidor.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((listaLineaP == null) ? 0 : listaLineaP.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (sku ^ (sku >>> 32));
		result = prime * result + unidades;
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
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (distribuidor == null) {
			if (other.distribuidor != null)
				return false;
		} else if (!distribuidor.equals(other.distribuidor))
			return false;
		if (id != other.id)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (listaLineaP == null) {
			if (other.listaLineaP != null)
				return false;
		} else if (!listaLineaP.equals(other.listaLineaP))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (sku != other.sku)
			return false;
		if (unidades != other.unidades)
			return false;
		return true;
	}
	
	
	//Metodos Helper
	
	
}
