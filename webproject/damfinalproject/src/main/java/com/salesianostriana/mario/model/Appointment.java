package com.salesianostriana.mario.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private Long id;

	private LocalDateTime endTime;
	private LocalDateTime startTime;
	private boolean isPaid;
	private LocalDateTime orderDate;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private Service service;

	public Appointment() {

	}

	public Appointment(LocalDateTime startTime, Client client, Employee employee, LocalDateTime endTime, boolean isPaid,
			LocalDateTime orderDate, Service service) {
		super();
		this.startTime = startTime;
		this.client = client;
		this.employee = employee;
		this.endTime = endTime;
		this.isPaid = isPaid;
		this.orderDate = orderDate;
		this.service = service;
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
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", startTime=" + startTime + ", client=" + client + ", employee=" + employee
				+ ", endTime=" + endTime + ", isPaid=" + isPaid + ", orderDate=" + orderDate + ", service=" + service
				+ "]";
	}

}
