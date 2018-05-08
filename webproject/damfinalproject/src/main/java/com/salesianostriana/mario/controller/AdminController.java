package com.salesianostriana.mario.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {
	// @GetMapping ("/productos")
	// public String controladorCondicionales (Model model){
	// //Para simplificar el ejemplo, se ha instanciado la lista y se han agregado
	// //algunos productos directamente dentro del método pero esto nunca se hace,
	// solo es para este ejemplo
	//
	// List<Product> lista = new ArrayList<Product>();
	//
	// lista.add(new Product (1, "Botijo", "Enfría agua hasta menos 10 grados",
	// 20.50, true, Calendar.getInstance()) );
	// lista.add(new Product (1, "BotijoExtra", "Enfría agua hasta menos 200
	// grados", 200.50, true, Calendar.getInstance()) );
	//
	// //Añadimos la lista al model con el nombre "productList" y será el usado en
	// la plantilla HTML para acceder
	// //a los datos que se han agregado al modelo (lista)
	// model.addAttribute("productList", lista );
	// return "PlantillaCondicionales";//Se devuelve la plantilla en HTML
	// }
	@GetMapping("/")
	public String a(Model model) {
		return "a";
	}
}
