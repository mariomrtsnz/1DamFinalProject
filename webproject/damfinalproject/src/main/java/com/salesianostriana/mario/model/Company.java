package com.salesianostriana.mario.model;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue
	private Long id;

	private String nif;
	private String address;
	private LocalTime closeTime;
	private LocalTime openTime;
	private String email;
	private String name;
	private String phone;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	Set<Employee> employees = new HashSet<Employee>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	Set<Client> clients = new HashSet<Client>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	Set<Treatment> treatments = new HashSet<Treatment>();

	public Company() {
	}

	public Company(String nif, String address, LocalTime closeTime, LocalTime openTime, String email, String name,
			String phone) {
		super();
		this.nif = nif;
		this.address = address;
		this.closeTime = closeTime;
		this.openTime = openTime;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public Company(String nif, String address, LocalTime closeTime, LocalTime openTime, String email, String name,
			String phone, Admin admin) {
		super();
		this.nif = nif;
		this.address = address;
		this.closeTime = closeTime;
		this.openTime = openTime;
		this.email = email;
		this.name = name;
		this.phone = phone;
		// this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(Set<Treatment> treatments) {
		this.treatments = treatments;
	}

	@Override
	public String toString() {
		return "Company [nif=" + nif + ", address=" + address + ", closeTime=" + closeTime + ", openTime=" + openTime
		// + ", email=" + email + ", name=" + name + ", phone=" + phone + ", admin=" +
		// admin + ", employees="
				+ employees + ", clients=" + clients + ", treatments=" + treatments + "]";
	}

	/*
	 * Métodos helper
	 */

	public void addClient(Client c) {
		if (c != null) {
			c.setCompany(this);
			this.getClients().add(c);
		}
	}

	public void removeClient(Client c) {
		if (c != null) {
			c.setCompany(null);
			this.getClients().remove(c);
		}
	}

	public void addEmployee(Employee e) {
		if (e != null) {
			e.setCompany(this);
			this.getEmployees().add(e);
		}
	}

	public void removeEmployee(Employee e) {
		if (e != null) {
			e.setCompany(null);
			this.getEmployees().remove(e);
		}
	}

	public void addTreatment(Treatment t) {
		if (t != null) {
			t.setCompany(this);
			this.getTreatments().add(t);
		}
	}

	public void removeTreatment(Treatment t) {
		if (t != null) {
			t.setCompany(null);
			this.getTreatments().remove(t);
		}
	}

}
