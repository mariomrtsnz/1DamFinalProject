package com.salesianostriana.b2b.model;

import java.util.HashSet;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Distribuidor {

	@GeneratedValue
	@Id
	private long idDistribuidor;
	private String nombre;
	private String cif;
	private String direccion;
	private String telefono;
	private String username;
	private String pass;
	private String email;
	
	@OneToMany
	//(mappedBy="distribuidor", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	Set<Producto> listaProducto = new HashSet<>();
	
	//Constructores
	public Distribuidor () {
		
	}

	





	public Distribuidor(String nombre, String cif, String direccion, String telefono, String username, String pass,
			String email, Set<Producto> listaProducto) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.listaProducto = listaProducto;
	}







	public Distribuidor(long idDistribuidor, String nombre, String cif, String direccion, String telefono,
			String username, String pass, String email, Set<Producto> listaProducto) {
		super();
		this.idDistribuidor = idDistribuidor;
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.listaProducto = listaProducto;
	}

	//Getters and Setters
	public long getIdDistribuidor() {
		return idDistribuidor;
	}

	public void setIdEmpresa(long idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
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
	
	

	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return "Distribuidor [idDistribuidor=" + idDistribuidor + ", nombre=" + nombre + ", cif=" + cif + ", direccion="
				+ direccion + ", telefono=" + telefono + ", username=" + username + ", pass=" + pass + ", email="
				+ email + ", listaProducto=" + listaProducto + "]";
	}


	//HashCode E Equals


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idDistribuidor ^ (idDistribuidor >>> 32));
		result = prime * result + ((listaProducto == null) ? 0 : listaProducto.hashCode());
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
		Distribuidor other = (Distribuidor) obj;
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
		if (idDistribuidor != other.idDistribuidor)
			return false;
		if (listaProducto == null) {
			if (other.listaProducto != null)
				return false;
		} else if (!listaProducto.equals(other.listaProducto))
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
	
	
	
	//Metodos Helper
	

}
