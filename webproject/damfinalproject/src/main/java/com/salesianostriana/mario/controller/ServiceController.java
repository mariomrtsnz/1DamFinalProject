package com.salesianostriana.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.mario.model.Service;
import com.salesianostriana.mario.service.ServiceService;

@Controller
public class ServiceController {

	ServiceService serviceService = new ServiceService();

//	@GetMapping("/service/{id}")
//	public String serviceDetail(@PathVariable("id") long id, Model model) {
//		Service s = serviceService.findOneById(id);
//		if (s != null) {
//			model.addAttribute("service", s);
//			return "ServiceDetail";
//		} else {
//			// Tratamiento del error
//			return "Error";
//		}
//	}

	@PostMapping("/addService")
	public String submit(@ModelAttribute("FormService") Model model) {
		return "";
	}
}