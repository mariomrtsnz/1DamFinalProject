package com.salesianostriana.mario.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

public class Appointment {
	// private Date appointmentDate;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Employee employee;
	private LocalDateTime endTime;
	@Id
	@GeneratedValue
	private Long id;
	private boolean isPaid;
	private LocalDate orderDate;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Service service;
	private LocalDateTime startTime;

	public Appointment() {

	}

	public Appointment(Client client, Employee employee, LocalDateTime endTime, boolean isPaid, LocalDate orderDate,
			Service service, LocalDateTime startTime) {
		super();
		this.client = client;
		this.employee = employee;
		this.endTime = endTime;
		this.isPaid = isPaid;
		this.orderDate = orderDate;
		this.service = service;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "Appointment [client=" + client + ", employee=" + employee + ", endTime=" + endTime + ", id=" + id
				+ ", isPaid=" + isPaid + ", orderDate=" + orderDate + ", service=" + service + ", startTime="
				+ startTime + "]";
	}

}
