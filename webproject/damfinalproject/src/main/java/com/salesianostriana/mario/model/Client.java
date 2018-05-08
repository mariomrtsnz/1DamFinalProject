package com.salesianostriana.mario.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Client {
	private List[] appointments;
	private String dni;
	private String email;
	private boolean hasAppointment;
	private boolean hasDuePayment;
	@Id
	@GeneratedValue
	private Long id;
	private boolean isHistorical;
	private String name;
	private String password;
	private String phone;
	// private image profilePic;

	public Client(List[] appointments, String dni, String email, boolean hasAppointment, boolean hasDuePayment,
			boolean isHistorical, String name, String password, String phone) {
		super();
		this.appointments = appointments;
		this.dni = dni;
		this.email = email;
		this.hasAppointment = hasAppointment;
		this.hasDuePayment = hasDuePayment;
		this.isHistorical = isHistorical;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public List[] getAppointments() {
		return appointments;
	}

	public void setAppointments(List[] appointments) {
		this.appointments = appointments;
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

	public boolean isHasAppointment() {
		return hasAppointment;
	}

	public void setHasAppointment(boolean hasAppointment) {
		this.hasAppointment = hasAppointment;
	}

	public boolean isHasDuePayment() {
		return hasDuePayment;
	}

	public void setHasDuePayment(boolean hasDuePayment) {
		this.hasDuePayment = hasDuePayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isHistorical() {
		return isHistorical;
	}

	public void setHistorical(boolean isHistorical) {
		this.isHistorical = isHistorical;
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

	@Override
	public String toString() {
		return "Client [appointments=" + Arrays.toString(appointments) + ", dni=" + dni + ", email=" + email
				+ ", hasAppointment=" + hasAppointment + ", hasDuePayment=" + hasDuePayment + ", id=" + id
				+ ", isHistorical=" + isHistorical + ", name=" + name + ", password=" + password + ", phone=" + phone
				+ "]";
	}

}
