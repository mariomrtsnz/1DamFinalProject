package com.salesianostriana.mario.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Company {
	private String address;
	private LocalDateTime closeTime;
	private LocalDateTime openTime;
	private String email;
	private String name;
	private String phone;

	public Company(String address, LocalDateTime closeTime, LocalDateTime openTime, String email, String name,
			String phone) {
		super();
		this.address = address;
		this.closeTime = closeTime;
		this.openTime = openTime;
		this.email = email;
		this.name = name;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "Company [address=" + address + ", closeTime=" + closeTime + ", openTime=" + openTime + ", email="
				+ email + ", name=" + name + ", phone=" + phone + "]";
	}

}
