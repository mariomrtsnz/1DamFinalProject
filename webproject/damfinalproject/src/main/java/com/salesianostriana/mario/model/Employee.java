package com.salesianostriana.mario.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "seq_employee")
	private Long id;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Appointment> appointments = new HashSet<Appointment>();
	@ManyToOne
	private Company company;
	@Column(unique = true)
	private String dni;
	@Column(unique = true)
	private String email;
	private double grossAnualSalary;
	private String name;
	private String password;
	private String phone;
	private String profilePic;
	private String position;
	private LocalDateTime hireDate;
	private boolean historical;
	private LocalDateTime historicalDate;

	public Employee() {

	}

	public Employee(String dni, String email, double grossAnualSalary, String name, String password, String phone,
			String profilePic, String position, LocalDateTime hireDate, LocalDateTime historicalDate) {
		super();
		this.dni = dni;
		this.email = email;
		this.grossAnualSalary = grossAnualSalary;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.profilePic = profilePic;
		this.position = position;
		this.hireDate = hireDate;
		this.historicalDate = historicalDate;
	}

	public Employee(Company company, String dni, String email, double grossAnualSalary, String name, String password,
			String phone, String profilePic, String position, LocalDateTime hireDate) {
		super();
		this.company = company;
		this.dni = dni;
		this.email = email;
		this.grossAnualSalary = grossAnualSalary;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.profilePic = profilePic;
		this.position = position;
		this.hireDate = hireDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isHistorical() {
		return historical;
	}

	public void setHistorical(boolean historical) {
		this.historical = historical;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getGrossAnualSalary() {
		return grossAnualSalary;
	}

	public void setGrossAnualSalary(double grossAnualSalary) {
		this.grossAnualSalary = grossAnualSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDateTime hireDate) {
		this.hireDate = hireDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public LocalDateTime getHistoricalDate() {
		return historicalDate;
	}

	public void setHistoricalDate(LocalDateTime historicalDate) {
		this.historicalDate = historicalDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", appointments=" + appointments + ", company=" + company + ", dni=" + dni
				+ ", email=" + email + ", grossAnualSalary=" + grossAnualSalary + ", name=" + name + ", password="
				+ password + ", phone=" + phone + ", profilePic=" + profilePic + ", position=" + position
				+ ", hireDate=" + hireDate + ", historical=" + historical + "]";
	}

	/*
	 * HELPER METHODS
	 */
	public void addAppointment(Appointment a) {
		if (a != null) {
			a.setEmployee(this);
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
