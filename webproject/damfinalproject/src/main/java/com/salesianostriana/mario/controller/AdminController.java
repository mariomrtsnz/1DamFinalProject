package com.salesianostriana.mario.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {
	// @GetMapping("/empleado")
	// public String showForm(Model model) {
	// Empleado empleado = new Empleado();
	// model.addAttribute("empleadoForm", empleado);
	// return "form";
	// }
	//
	// @PostMapping("/addEmpleado")
	// public String submit(@ModelAttribute("empleadoForm") Empleado empleado, Model
	// model) {
	// // System.out.println(empleado);
	// // Se añade al modelo, el empleado que se creará al recoger los datos del for
	// model.addAttribute("empleado", empleado);
	//
	// return "view";
	// }
	
	@GetMapping("/")
	public String a(Model model) {
		return "a";
	}
}
