package com.salesianostriana.dam.th02expresiones.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.th02expresiones.model.Customer;

/*Como en el ejemplo, las peticiones de los productos no están relacionadas con las de los clientes
 * creamos una nueva clase controller para los clientes (customer) y la anotamos con @Controller*/

@Controller
public class CustomerController {
	
	@GetMapping("/listGen")
	public String listarVarios (Model model) {
		
		/*se ha metido aquí la lista para no tener que escribir 
		 * el repositorio, etc. No se hace en el proyecto, solo como ejemplo*/
		
		List<Customer> lista = new ArrayList<Customer>();
		
		lista.add(new Customer("Ángel", "Naranjo", "González", "male", 1));
		lista.add(new Customer ("Perry", "Mason", "Mason", "male", 2));
		lista.add(new Customer ("Novia del Gato", "Doraemon", "No sé", "female", 3));
		lista.add(new Customer ("weskered", "Smith", "Svensson", " ", 3));
		
		//Agregamos la lista al modelo
		model.addAttribute("customerList", lista);
		
		return "PlantillaGenero";
	}
	
}
