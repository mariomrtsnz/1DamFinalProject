package com.salesianostriana.mario.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@SequenceGenerator(name = "appointment_seq", sequenceName = "seq_appointment")
	private Long id;

	private LocalDateTime endTime;
	private LocalDateTime startTime;
	private boolean paid;
	private LocalDateTime orderDate;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private Treatment treatment;

	public Appointment() {

	}

	public Appointment(LocalDateTime startTime, Client client, Employee employee, LocalDateTime endTime, boolean isPaid,
			LocalDateTime orderDate, Treatment treatment) {
		super();
		this.startTime = startTime;
		this.client = client;
		this.employee = employee;
		this.endTime = endTime;
		this.paid = isPaid;
		this.orderDate = orderDate;
		this.treatment = treatment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean isPaid) {
		this.paid = isPaid;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", startTime=" + startTime + ", client=" + client + ", employee=" + employee
				+ ", endTime=" + endTime + ", isPaid=" + paid + ", orderDate=" + orderDate + ", service=" + treatment
				+ "]";
	}

}
