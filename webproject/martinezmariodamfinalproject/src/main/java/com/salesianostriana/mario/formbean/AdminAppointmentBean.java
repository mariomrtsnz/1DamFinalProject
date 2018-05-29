package com.salesianostriana.mario.formbean;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class AdminAppointmentBean {
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
//	private String clientName;
//	private String employeeName;
//	private String treatmentName;
	private Long clientId;
	private Long employeeId;
	private Long treatmentId;
	private boolean paid;

	public AdminAppointmentBean() {
	}

	public AdminAppointmentBean(LocalTime startTime, LocalDate startDate, Long clientId, Long employeeId,
			Long treatmentId, boolean paid) {
		super();
		this.startTime = startTime;
		this.startDate = startDate;
		this.clientId = clientId;
		this.employeeId = employeeId;
		this.treatmentId = treatmentId;
		this.paid = paid;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Long treatmentId) {
		this.treatmentId = treatmentId;
	}

}
