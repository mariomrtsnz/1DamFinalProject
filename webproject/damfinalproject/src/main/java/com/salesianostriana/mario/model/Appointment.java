package com.salesianostriana.mario.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Appointment {
	// private Date appointmentDate;
	private Client client;
	private Employee employee;
	// private Time endTime;
	@Id
	@GeneratedValue
	private Long id;
	private boolean isPaid;
	// private Date orderDate;
	private Service service;

	// private Time startTime;

	public Appointment(Client client, Employee employee, boolean isPaid, Service service) {
		super();
		this.client = client;
		this.employee = employee;
		this.isPaid = isPaid;
		this.service = service;
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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Appointment [client=" + client + ", employee=" + employee + ", id=" + id + ", isPaid=" + isPaid
				+ ", service=" + service + "]";
	}

}
