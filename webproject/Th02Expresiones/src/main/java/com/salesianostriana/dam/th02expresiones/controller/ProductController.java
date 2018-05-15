package com.salesianostriana.dam.th02expresiones.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.salesianostriana.dam.th02expresiones.model.Product;

/*Clase controlador que será quien atienda a nuestras peticiones, en este caso, al estar
 * el método anotado con @GetMapping, se atenderá a las peticiones tipo get. Para ello, 
 * como siempre, se escribe en el navegador, detrás de localhost:9000/productos (variable 
 * escrita en el GetMapping*/

@Controller
public class ProductController {

	@GetMapping ("/productos")
	public String controladorCondicionales (Model model){
		//Para simplificar el ejemplo, se ha instanciado la lista y se han agregado
		//algunos productos directamente dentro del método pero esto nunca se hace, solo es para este ejemplo
		
		List<Product> lista = new ArrayList<Product>();
		
		lista.add(new Product (1, "Botijo", "Enfría agua hasta menos 10 grados", 20.50, true, Calendar.getInstance()) );
		lista.add(new Product (1, "BotijoExtra", "Enfría agua hasta menos 200 grados", 200.50, true, Calendar.getInstance()) );
		
		//Añadimos la lista al model con el nombre "productList" y será el usado en la plantilla HTML para acceder
		//a los datos que se han agregado al modelo (lista)
		model.addAttribute("productList", lista  );
		return "PlantillaCondicionales";//Se devuelve la plantilla en HTML
	}
	
	
	
}
