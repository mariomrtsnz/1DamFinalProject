package com.salesianostriana.mario.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Admin {
	@Id
	private String nif;
	private String email;
	private String name;
	private String password;
	private String phone;
	private String profilePic;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "nif")
	private Company company;

	public Admin() {

	}

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

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Admin [nif=" + nif + ", email=" + email + ", name=" + name + ", password=" + password + ", phone="
				+ phone + ", profilePic=" + profilePic + "]";
	}

}
