package com.salesianostriana.mario.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Treatment {
	@Id
	@GeneratedValue
	private Long id;

	private String description;
	private int discount;
	private boolean isPaidInInstallments;
	private String name;
	private int numSessions;
	private double totalPrice;
	@OneToMany(mappedBy = ("treatment"), cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	Set<Appointment> appointments = new HashSet<Appointment>();
	@ManyToOne
	private Company company;

	public Treatment(String description, int discount, boolean isPaidInInstallments, String name, int numSessions,
			double totalPrice, Company company) {
		super();
		this.description = description;
		this.discount = discount;
		this.isPaidInInstallments = isPaidInInstallments;
		this.name = name;
		this.numSessions = numSessions;
		this.totalPrice = totalPrice;
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPaidInInstallments() {
		return isPaidInInstallments;
	}

	public void setPaidInInstallments(boolean isPaidInInstallments) {
		this.isPaidInInstallments = isPaidInInstallments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumSessions() {
		return numSessions;
	}

	public void setNumSessions(int numSessions) {
		this.numSessions = numSessions;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Service [description=" + description + ", discount=" + discount + ", id=" + id
				+ ", isPaidInInstallments=" + isPaidInInstallments + ", name=" + name + ", numSessions=" + numSessions
				+ ", totalPrice=" + totalPrice + "]";
	}

	/*
	 * MÉTODOS HELPER
	 */
	public void addAppointment(Appointment a) {
		if (a != null) {
			a.setTreatment(this);
			this.getAppointments().add(a);
		}
	}

	public void removeAppointment(Appointment a) {
		if (a != null) {
			a.setEmployee(null);
			this.getAppointments().remove(a);
		}
	}

}
