package com.salesianostriana.mario.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatment_seq")
	@SequenceGenerator(name = "treatment_seq", sequenceName = "seq_treatment", allocationSize=1)
	private Long id;

	private String description;
	private int discount;
	private boolean paidInInstallments;
	@Column(unique = true)
	private String name;
	private int numSessions;
	private double totalPrice;
	@OneToMany(mappedBy="treatment", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Appointment> appointments = new HashSet<Appointment>();
	@ManyToOne
	private Company company;
	private String picture;
	private boolean historical;

	public Treatment(String description, int discount, boolean isPaidInInstallments, String name, int numSessions,
			double totalPrice, Company company) {
		super();
		this.description = description;
		this.discount = discount;
		this.paidInInstallments = isPaidInInstallments;
		this.name = name;
		this.numSessions = numSessions;
		this.totalPrice = totalPrice;
		this.company = company;
	}

	public Treatment() {
	}

	public Treatment(String description, int discount, boolean isPaidInInstallments, String name, int numSessions,
			double totalPrice, String picture) {
		super();
		this.description = description;
		this.discount = discount;
		this.paidInInstallments = isPaidInInstallments;
		this.name = name;
		this.numSessions = numSessions;
		this.totalPrice = totalPrice;
		this.picture = picture;
	}

	public Treatment(String description, int discount, boolean paidInInstallments, String name, int numSessions,
			double totalPrice) {
		super();
		this.description = description;
		this.discount = discount;
		this.paidInInstallments = paidInInstallments;
		this.name = name;
		this.numSessions = numSessions;
		this.totalPrice = totalPrice;
	}

	public boolean isHistorical() {
		return historical;
	}

	public void setHistorical(boolean historical) {
		this.historical = historical;
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
		return paidInInstallments;
	}

	public void setPaidInInstallments(boolean isPaidInInstallments) {
		this.paidInInstallments = isPaidInInstallments;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Service [description=" + description + ", discount=" + discount + ", id=" + id
				+ ", isPaidInInstallments=" + paidInInstallments + ", name=" + name + ", numSessions=" + numSessions
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
