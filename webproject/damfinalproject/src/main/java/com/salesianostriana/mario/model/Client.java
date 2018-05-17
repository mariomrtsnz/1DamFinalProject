package com.salesianostriana.mario.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
	@SequenceGenerator(name = "client_seq", sequenceName = "seq_client")
	private Long id;

	private String dni;
	private String email;
	private boolean hasDuePayment;
	private boolean historical;
	private String name;
	private String password;
	private String phone;
	private String profilePic;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	Set<Appointment> appointments = new HashSet<Appointment>();
	@ManyToOne
	private Company company;
	private LocalDateTime registerDate;

	public Client() {
	};

	public Client(String dni, String email, boolean hasDuePayment, boolean isHistorical, String name, String password,
			String phone, String profilePic, LocalDateTime registerDate) {
		super();
		this.dni = dni;
		this.email = email;
		this.hasDuePayment = hasDuePayment;
		this.historical = isHistorical;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.profilePic = profilePic;
		this.registerDate = registerDate;
	}

	public Client(String dni, String email, boolean hasDuePayment, boolean isHistorical, String name, String password,
			String phone, String profilePic, Company company, LocalDateTime registerDate) {
		super();
		this.dni = dni;
		this.email = email;
		this.hasDuePayment = hasDuePayment;
		this.historical = isHistorical;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.profilePic = profilePic;
		this.company = company;
		this.registerDate = registerDate;
	}

	public Client(String dni, String email, String name, String password, String phone, LocalDateTime registerDate) {
		super();
		this.dni = dni;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.registerDate = registerDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public boolean isHasDuePayment() {
		return hasDuePayment;
	}

	public void setHasDuePayment(boolean hasDuePayment) {
		this.hasDuePayment = hasDuePayment;
	}

	public boolean isHistorical() {
		return historical;
	}

	public void setHistorical(boolean isHistorical) {
		this.historical = isHistorical;
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

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", dni=" + dni + ", email=" + email + ", hasDuePayment=" + hasDuePayment
				+ ", isHistorical=" + historical + ", name=" + name + ", password=" + password + ", phone=" + phone
				+ ", profilePic=" + profilePic + ", appointments=" + appointments + ", company=" + company
				+ ", registerDate=" + registerDate + "]";
	}

	/*
	 * MÉTODOS HELPER
	 */
	public void addAppointment(Appointment a) {
		if (a != null) {
			a.setClient(this);
			this.getAppointments().add(a);
		}
	}

	public void removeAppointment(Appointment a) {
		if (a != null) {
			a.setClient(null);
			this.getAppointments().remove(a);
		}
	}

}
