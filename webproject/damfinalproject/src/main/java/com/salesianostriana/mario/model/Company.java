package com.salesianostriana.mario.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Company {
	@Id
	private String nif;
	private String address;
	private LocalDateTime closeTime;
	private LocalDateTime openTime;
	private String email;
	private String name;
	private String phone;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "dni")
	private Admin admin;

	public Company(String nif, String address, LocalDateTime closeTime, LocalDateTime openTime, String email,
			String name, String phone, Admin admin) {
		super();
		this.nif = nif;
		this.address = address;
		this.closeTime = closeTime;
		this.openTime = openTime;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.admin = admin;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalDateTime closeTime) {
		this.closeTime = closeTime;
	}

	public LocalDateTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalDateTime openTime) {
		this.openTime = openTime;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Company [nif=" + nif + ", address=" + address + ", closeTime=" + closeTime + ", openTime=" + openTime
				+ ", email=" + email + ", name=" + name + ", phone=" + phone + ", admin=" + admin + "]";
	}

}
