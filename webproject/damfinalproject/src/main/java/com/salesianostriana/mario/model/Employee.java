package com.salesianostriana.mario.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Employee {
	private List[] appointments;
	private String dni;
	private String email;
	private double grossAnualSalary;
	@Id
	@GeneratedValue
	private Long id;
	private String Name;
	private String password;
	private String phone;
	private String position;
	// private image profilePic;

	public Employee(List[] appointments, String dni, String email, double grossAnualSalary, String name,
			String password, String phone, String position) {
		super();
		this.appointments = appointments;
		this.dni = dni;
		this.email = email;
		this.grossAnualSalary = grossAnualSalary;
		Name = name;
		this.password = password;
		this.phone = phone;
		this.position = position;
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

	public double getGrossAnualSalary() {
		return grossAnualSalary;
	}

	public void setGrossAnualSalary(double grossAnualSalary) {
		this.grossAnualSalary = grossAnualSalary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [appointments=" + Arrays.toString(appointments) + ", dni=" + dni + ", email=" + email
				+ ", grossAnualSalary=" + grossAnualSalary + ", id=" + id + ", Name=" + Name + ", password=" + password
				+ ", phone=" + phone + ", position=" + position + "]";
	}

}
