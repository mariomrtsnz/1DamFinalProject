package com.salesianostriana.mario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Company;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.service.AdminService;
import com.salesianostriana.mario.service.AppointmentService;
import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.CompanyService;
import com.salesianostriana.mario.service.EmployeeService;
import com.salesianostriana.mario.service.TreatmentService;

@SpringBootApplication
public class DamFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamFinalProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabase(ClientService clientService, AppointmentService appointmentService,
			EmployeeService employeeService, TreatmentService treatmentService, CompanyService companyService, AdminService adminService) {
		return args -> {

			Company company = new Company("55123456T", "c/ Alejo Fernández, 13, 41003", LocalTime.of(19, 00), LocalTime.of(10, 00), "contact@realworlddental.com", "RealWorld Dental", "954 335 932");
////			Company company = new Company();
//			companyService.save(company);
			Admin admin = new Admin("55123456T", "admin@rwd.com", "Admin", "admin", "11",
					"/images/profilePics/profile-admin.jpg");
//			adminService.save(admin);
//			company.setAdmin(admin);

			
			Client c = new Client("77927639M", "mario.mrtsnz@gmail.com", true, false, "Mario Martínez Sanz", "1234",
					"678377084", "fotoMarioMartinez", LocalDateTime.now());
			c = clientService.save(c);
//			company.addClient(c);
			Client c1 = new Client("00988766D", "test.client@rwd.com", false, true, "Frank Castle", "frankcastle",
					"882764410", "fotoFrankCastle", LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30));
			c1 = clientService.save(c1);
//			company.addClient(c1);
//
			Employee e = new Employee("12345678B", "test@rwd.com", 20000.00, "test", "employee", "098765432",
					"noPicture", "Administrative", LocalDateTime.of(2018, 5, 3, 7, 30));
			e = employeeService.save(e);
//			company.addEmployee(e);
			Employee e1 = new Employee("10293847C", "harveydent@rwd.com", 40000.00, "Harvey Dent", "batman",
					"666777888", "noPicture2", "Dentist", LocalDateTime.of(2018, 3, 1, 6, 29));
			e1 = employeeService.save(e1);
//			company.addEmployee(e1);
//
			Treatment t = new Treatment("Para dientes blancos", 10, false, "Blanqueamiento", 1, 150);
			t = treatmentService.save(t);
			Treatment t1 = new Treatment("Para corregir dientes", 0, true, "Ortodoncia", 5, 500);
			t1 = treatmentService.save(t1);
//			company.addTreatment(t);
//
			Appointment a1 = new Appointment(LocalDateTime.of(2013, 12, 27, 10, 00), c1, e,
					LocalDateTime.of(2013, 12, 27, 11, 00), false, LocalDateTime.of(2013, 12, 20, 16, 00), t);
			a1 = appointmentService.save(a1);
			c1.addAppointment(a1);
			e.addAppointment(a1);
			t.addAppointment(a1);
			Appointment a2 = new Appointment(LocalDateTime.of(2013, 12, 18, 14, 30), c, e1,
					LocalDateTime.of(2013, 12, 18, 15, 30), true, LocalDateTime.of(2013, 12, 15, 18, 00), t1);
			a2 = appointmentService.save(a2);
			c.addAppointment(a2);
			e1.addAppointment(a2);
			t1.addAppointment(a2);

//
//			companyService.save(company);
//
//			System.out.println(c);
//			System.out.println(a1);
//			System.out.println(a2);
//
//			Client c2 = clientService.findOne(c.getId());
//
//			System.out.println(c2);
//
//			// or
			System.out.println(clientService.findOne(c.getId()));
//
		};
	}
}
