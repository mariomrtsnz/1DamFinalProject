package com.salesianostriana.mario.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private String nif;
	private String email;
	private String name;
	private String password;
	private String phone;
	private String profilePic;

	public Admin(String nif, String email, String name, String password, String phone, String profilePic) {
		super();
		this.nif = nif;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.profilePic = profilePic;
	}

	public String getDni() {
		return nif;
	}

	public void setDni(String nif) {
		this.nif = nif;
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
		return "Admin [nif=" + nif + ", email=" + email + ", name=" + name + ", password=" + password + ", phone="
				+ phone + ", profilePic=" + profilePic + "]";
	}

}
