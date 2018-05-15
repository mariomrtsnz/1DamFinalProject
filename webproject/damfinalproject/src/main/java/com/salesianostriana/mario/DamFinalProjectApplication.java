package com.salesianostriana.mario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DamFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamFinalProjectApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner testDatabase(ClientService clientService, AppointmentService appointmentService) {
//		return args -> {
//
//			Client c = new Client();
//			c = clientService.save(c);
//
//			Appointment f1 = new Appointment();
//			Appointment f2 = new Appointment();
//			f1 = appointmentService.save(f1);
//			f2 = appointmentService.save(f2);
//
//			// Aquí está la diferencia con el código del Ejemplo 02.
//			c.addAppointment(f1);
//			c.addAppointment(f2);
//
//			System.out.println(c);
//			System.out.println(f1);
//			System.out.println(f2);
//
//			Client c1 = clientService.findOne(c.getId());
//
//			System.out.println(c1);
//
//		};
//	}
}
