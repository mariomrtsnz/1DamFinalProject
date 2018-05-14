package com.salesianostriana.mario.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private String dni;
	private String email;
	private String name;
	private String password;
	private String phone;
	private String profilePic;

	public Admin(String dni, String email, String name, String password, String phone, String profilePic) {
		super();
		this.dni = dni;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.profilePic = profilePic;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "Admin [dni=" + dni + ", email=" + email + ", name=" + name + ", password=" + password + ", phone="
				+ phone + ", profilePic=" + profilePic + "]";
	}

}
