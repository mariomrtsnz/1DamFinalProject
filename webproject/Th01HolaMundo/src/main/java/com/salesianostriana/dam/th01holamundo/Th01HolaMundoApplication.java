package com.salesianostriana.dam.th01holamundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//La clase principal solo lleva el método main y la llamada a run, método que arranca la aplicación.
//Usaremos anotaciones como la que aparece abajao para ir utilizando las catacterísticas de Spring que facilita muchísimo la vida del programador
//Por ejemplo esta primera indica que la aplicación es SpringBoot

@SpringBootApplication
public class Th01HolaMundoApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(Th01HolaMundoApplication.class, args);
	}
}
