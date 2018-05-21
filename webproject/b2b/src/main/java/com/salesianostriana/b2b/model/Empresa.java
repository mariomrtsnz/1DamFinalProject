package com.salesianostriana.b2b.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa {

	@GeneratedValue
	@Id
	private long idEmpresa;
	private String nombre;
	private String cif;
	private String direccion;
	private String telefono;
	private String username;
	private String pass;
	private String email;
	
	@OneToMany
	Set<Pedido> listaPedido = new HashSet<>();
	
	//Constructores
	public Empresa () {
		
	}
	
	public Empresa(long idEmpresa, String nombre, String cif, String direccion, String telefono, String username,
			String pass, String email, Set<Pedido> listaPedido) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.listaPedido = listaPedido;
	}



	public Empresa(String nombre, String cif, String direccion, String telefono, String username, String pass,
			String email, Set<Pedido> listaPedido) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.listaPedido = listaPedido;
	}



	//Getters And Setters
	public long getIdEmpresa() {
		return idEmpresa;
	}
	
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//toString
	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nombre=" + nombre + ", cif=" + cif + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", username=" + username + ", pass=" + pass + ", email=" + email
				+ ", listaPedido=" + listaPedido + "]";
	}

	// HashCode e Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idEmpresa ^ (idEmpresa >>> 32));
		result = prime * result + ((listaPedido == null) ? 0 : listaPedido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idEmpresa != other.idEmpresa)
			return false;
		if (listaPedido == null) {
			if (other.listaPedido != null)
				return false;
		} else if (!listaPedido.equals(other.listaPedido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	// Metodos Helper
	
	
	
	
}
