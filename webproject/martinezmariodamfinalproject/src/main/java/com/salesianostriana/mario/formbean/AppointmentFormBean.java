package com.salesianostriana.mario.formbean;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentFormBean {
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	public AppointmentFormBean() {}
	
	public AppointmentFormBean(LocalTime startTime, LocalDate startDate) {
		super();
		this.startTime = startTime;
		this.startDate = startDate;
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

}
