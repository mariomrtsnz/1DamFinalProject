package com.salesianostriana.mario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Service {
	@Id
	@GeneratedValue
	private Long id;

	private String description;
	private int discount;
	private boolean isPaidInInstallments;
	private String name;
	private int numSessions;
	private double totalPrice;

	public Service(String description, int discount, boolean isPaidInInstallments, String name, int numSessions,
			double totalPrice) {
		super();
		this.description = description;
		this.discount = discount;
		this.isPaidInInstallments = isPaidInInstallments;
		this.name = name;
		this.numSessions = numSessions;
		this.totalPrice = totalPrice;
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

	@Override
	public String toString() {
		return "Service [description=" + description + ", discount=" + discount + ", id=" + id
				+ ", isPaidInInstallments=" + isPaidInInstallments + ", name=" + name + ", numSessions=" + numSessions
				+ ", totalPrice=" + totalPrice + "]";
	}

}
