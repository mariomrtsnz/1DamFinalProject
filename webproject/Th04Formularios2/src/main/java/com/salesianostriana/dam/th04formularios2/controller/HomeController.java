package com.salesianostriana.dam.th04formularios2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*Se ha hecho un controller solo para la página principal para que se vaya viendo que habrá varios controller
 * dependiendo de las entidades o procesos que queramos gestionar en nuestra app*/

@Controller
public class HomeController {
	
	//Peticiones tipo get que nos llevarán a la página principal, no hay que añadir ningún atributo 
	//ni pasar ningún model porque no hace falta, es solo el que atiende a la petición de abrir la página
	//web de la aplicación
	//En getMapping, solo la barra significa que no es necesario pedir ningún recurso, al escribir en el navegador 
	//localhost:9000 nos llevará a la página principal (otra tienda) que tenemos como plantilla Main.html
	
	
	@GetMapping("/")
	public String welcome() {
		return "Main";
	}
	
}
