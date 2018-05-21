package com.salesianostriana.b2b;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.salesianostriana.b2b.model.Administrador;
import com.salesianostriana.b2b.model.Distribuidor;
import com.salesianostriana.b2b.model.Empresa;
//import com.salesianostriana.b2b.model.Distribuidor;
//import com.salesianostriana.b2b.model.Empresa;
import com.salesianostriana.b2b.service.AdministradorService;
import com.salesianostriana.b2b.service.DistribuidorService;
import com.salesianostriana.b2b.service.EmpresaService;


@SpringBootApplication
public class B2bApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2bApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insertInitialData(AdministradorService service, EmpresaService serviceb, DistribuidorService servicec) {
		return args -> {
			Administrador user1 = new Administrador();
			Distribuidor user3 = new Distribuidor();
			Empresa user2 = new Empresa();
			
			user1.setUsername("luismi");
			user1.setPass("luismi");
			service.save(user1);
			
			
			user2.setUsername("luismi2");
			user2.setPass("luismi2");
			user3.setPass("luismi3");
			user2.setNombre("luismiA");
			user2.setEmail("luismi@luismi");
			user2.setDireccion("calle luismi");
			user2.setCif("12345");
			serviceb.save(user2);
			
			
			user3.setUsername("luismi3");
			user3.setPass("luismi3");
			user3.setNombre("luismiB");
			user3.setEmail("luismi@luismi");
			user3.setDireccion("calle luismi");
			user3.setCif("12345");
			servicec.save(user3);

		};
	}
	
	
}
