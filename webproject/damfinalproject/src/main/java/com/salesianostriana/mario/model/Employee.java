package com.salesianostriana.mario.model;

import java.time.LocalDateTime;
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
public class Employee {
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = ("employee"), cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Appointment> appointments = new HashSet<Appointment>();
	@ManyToOne
	private Company company;
	private String dni;
	private String email;
	private double grossAnualSalary;
	private String name;
	private String password;
	private String phone;
	private String profilePic;
	private String position;
	private LocalDateTime hireDate;

	public Employee() {

	}

	public Employee(String dni, String email, double grossAnualSalary, String name, String password, String phone,
			String profilePic, String position, LocalDateTime hireDate) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", appointments=" + appointments + ", company=" + company + ", dni=" + dni
				+ ", email=" + email + ", grossAnualSalary=" + grossAnualSalary + ", name=" + name + ", password="
				+ password + ", phone=" + phone + ", profilePic=" + profilePic + ", position=" + position
				+ ", hireDate=" + hireDate + "]";
	}

	/*
	 * MÉTODOS HELPER
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
