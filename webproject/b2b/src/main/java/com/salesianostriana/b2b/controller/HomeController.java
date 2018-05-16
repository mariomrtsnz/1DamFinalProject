package com.salesianostriana.b2b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	//Devuelve la página principal
	@GetMapping("/Index")
	public String index() {
		return "Index";
}
	
	@GetMapping({"/", "/index"})
	public String home() {
		return "Index";
}
}
