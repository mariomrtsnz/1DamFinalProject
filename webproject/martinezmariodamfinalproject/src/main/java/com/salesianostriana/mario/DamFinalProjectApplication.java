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
			EmployeeService employeeService, TreatmentService treatmentService, CompanyService companyService,
			AdminService adminService) {
		return args -> {

			Company company = new Company("55123456T", "c/ Alejo Fernández, 13, 41003", LocalTime.of(19, 00),
					LocalTime.of(10, 00), "contact@realworlddental.com", "RealWorld Dental", "954 335 932");
			Admin admin = new Admin("55123456T", "admin@admin.com", "Admin", "admin", "664560382",
					"/images/profilePics/profile-admin.jpg");
			companyService.save(company, admin);

			Client c = new Client("77927639M", "usuario@usuario.com", true, false, "Mario Martínez Sanz", "1234",
					"678377084", "fotoMarioMartinez", LocalDateTime.now());
			c = clientService.save(c);
			company.addClient(c);
			Client c1 = new Client("00988766D", "frank.castle@rwd.com", false, true, "Frank Castle", "frankcastle",
					"882764410", "fotoFrankCastle", LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30));
			c1 = clientService.save(c1);
			company.addClient(c1);

			Employee e = new Employee("12345678B", "batman@rwd.com", 20000.00, "Bruce Wayne", "batman", "098765432",
					"/images/staff/male1.jpg", "Administrativo", LocalDateTime.of(2018, 5, 3, 7, 30), null);
			e = employeeService.save(e);
			company.addEmployee(e);
			Employee e1 = new Employee("10293847C", "harveydent@rwd.com", 40000.00, "Harvey Dent", "harveydent",
					"666777888", "/images/staff/male2.jpg", "Dentista", LocalDateTime.of(2018, 3, 1, 6, 29), null);
			e1 = employeeService.save(e1);
			company.addEmployee(e1);
			Employee e2 = new Employee("10293847C", "poisonivy@rwd.com", 40000.00, "Poison Ivy", "poisonivy",
					"666777888", "/images/staff/female1.jpg", "Dentista", LocalDateTime.of(2018, 3, 1, 6, 29), null);
			e2 = employeeService.save(e2);
			company.addEmployee(e2);
			Employee e3 = new Employee("10293847C", "catwoman@rwd.com", 40000.00, "Selina Kyle", "catwoman",
					"666777888", "/images/staff/female2.jpg", "Dentista", LocalDateTime.of(2018, 3, 1, 6, 29), null);
			e3 = employeeService.save(e3);
			company.addEmployee(e3);
			Employee e4 = new Employee("10293847C", "barbaragordon@rwd.com", 40000.00, "Bárbara Gordon", "barbaragordon",
					"666777888", "/images/staff/female3.jpg", "Administrativo", LocalDateTime.of(2018, 3, 1, 6, 29), null);
			e4 = employeeService.save(e4);
			company.addEmployee(e4);
			Employee e5 = new Employee("10293847C", "enygma@rwd.com", 40000.00, "Edward Nygma", "enygma",
					"666777888", "/images/staff/male3.jpg", "Dentista", LocalDateTime.of(2018, 3, 1, 6, 29), null);
			e5 = employeeService.save(e5);
			company.addEmployee(e5);

			Treatment t = new Treatment(
					"Los dientes son muy importantes para su apariencia. Te ves más joven con los dientes más blancos. Aquí en RealWorldDental blanqueamos tus dientes con la última tecnología.",
					10, false, "Blanqueamiento", 1, 150, "/images/services/teethwhitening.jpg");
			t = treatmentService.save(t);
			company.addTreatment(t);
			Treatment t2 = new Treatment(
					"Se utilizan para ocultar dientes agrietados, menos estéticos , o dientes descoloridos. Se utiliza preferentemente en los dientes frontales.",
					0, true, "Carillas", 2, 100, "/images/services/carillas.png");
			t2 = treatmentService.save(t2);
			company.addTreatment(t2);
			Treatment t3 = new Treatment(
					"Una corona es la mejor opción cuando se trata de una gran parte del diente la que necesita ser reemplazada o si vemos que el diente por estética necesite cambiar el color o la forma.",
					5, false, "Coronas y Puentes", 2, 200, "/images/services/corona.jpg");
			t3 = treatmentService.save(t3);
			company.addTreatment(t3);
			Treatment t4 = new Treatment(
					"Para arreglar hasta las pequeñas lesiones de caries. Consiste en anestesia, limpieza de la caries, relleno de la cavidad y pulido del empaste.",
					0, false, "Empaste", 1, 50, "/images/services/empaste.png");
			t4 = treatmentService.save(t4);
			company.addTreatment(t4);
			Treatment t5 = new Treatment(
					"Necesaria cuando existe una hipersensibilidad en el diente, dolor al masticar o dolor ante el consumo de bebidas muy frías o muy calientes ocasionados por la presencia de caries en el diente.",
					5, false, "Endodoncia", 1, 80, "/images/services/endodoncia.jpg");
			t5 = treatmentService.save(t5);
			company.addTreatment(t5);
			Treatment t6 = new Treatment(
					"Los implantes dentales se utilizan cuando haya perdido uno o más dientes. Es una elección segura y duradera para toda la vida.",
					0, true, "Implante", 2, 140, "/images/services/implante.png");
			t6 = treatmentService.save(t6);
			company.addTreatment(t6);
			Treatment t7 = new Treatment(
					"Encargada de explorar y tratar a niños y recién nacidos. También se encarga de detectar posibles anomalías en la posición de los maxilares o dientes para remitir al ortodoncista.",
					0, false, "Odontopediatría", 1, 60, "/images/services/odontopediatria.png");
			t7 = treatmentService.save(t7);
			company.addTreatment(t7);
			Treatment t1 = new Treatment(
					"A veces los dientes crecen en una posición inadecuada o se han movido debido a varios motivos. Mediante la ortodoncia podemos hacer cualquier corrección.",
					0, true, "Ortodoncia", 5, 500, "/images/services/ortodoncia.jpg");
			t1 = treatmentService.save(t1);
			company.addTreatment(t1);
			Treatment t8 = new Treatment(
					"Proviene de una enfermedad inflamatoria que afecta principalmente a los tejidos que sostienen los dientes. Es de avance lento. Si no recibes tratamiento, pueden pasar muchos años antes de perder los dientes.",
					5, false, "Periodontitis", 1, 60, "/images/services/periodontitis.jpg");
			t8 = treatmentService.save(t8);
			company.addTreatment(t8);
			Treatment t9 = new Treatment(
					"Revisar tu boca al menos una vez al año es una medida preventiva que te llevará unos minutos de tu tiempo, sin embargo, el beneficio que vas a obtener es mucho mayor.",
					0, false, "Revisión", 1, 30, "/images/services/revision.jpg");
			t9 = treatmentService.save(t9);
			company.addTreatment(t9);

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

			Appointment a3 = new Appointment(LocalDateTime.of(2018, 10, 24, 15, 00), c1, e1,
					LocalDateTime.of(2018, 10, 24, 16, 00), false, LocalDateTime.of(2018, 9, 30, 11, 00), t2);
			a3 = appointmentService.save(a3);
			c1.addAppointment(a3);
			e1.addAppointment(a3);
			t2.addAppointment(a3);

			Appointment a4 = new Appointment(LocalDateTime.of(2018, 8, 3, 16, 00), c, e,
					LocalDateTime.of(2018, 8, 3, 17, 00), false, LocalDateTime.of(2018, 8, 1, 19, 00), t3);
			a4 = appointmentService.save(a4);
			c.addAppointment(a4);
			e.addAppointment(a4);
			t3.addAppointment(a4);

			// Test
			// System.out.println(treatmentService.calculatePriceWithDiscount(t3));
			// System.out.println(clientService.findOne(c.getId()));
			// System.out.println(company.getId());
			// employeeService.findFirstAvailableByDateTime(LocalDateTime.now());
		};
	}
}
