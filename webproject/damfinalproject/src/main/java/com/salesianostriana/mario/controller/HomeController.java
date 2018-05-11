package com.salesianostriana.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// Devuelve la página de bienvenida (index.html) cuando se hace la petición.
	@GetMapping("/")
	public String indexPage(Model model) {
		return "index";
	}
}
