package com.salesianostriana.mario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class ClientController {

	@Autowired
	private ClientService service;
	
	@Autowired
	private TreatmentService treatmentService;

	@GetMapping("/public")
	public String index() {
		return "/public/user-index";
	}
	
	@GetMapping("/publiclayout")
	public String publicLayout(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		return "/fragments/publiclayout";
	}
	
//	@GetMapping("/public")
//	public String index(Model model) {
//		model.addAttribute(loggedUser);
//		return "/public/user-index";
//	}
	
	@GetMapping("/public/services")
	public String services() {
		return "/public/user-services";
	}
	
	@GetMapping("/public/aboutus")
	public String aboutUs() {
		return "/public/user-aboutus";
	}
	
	@GetMapping("/public/contactus")
	public String contactUs() {
		model.addAttribute("treatments", treatmentService.findAll());
		return "/public/user-contactus";
	}
	
	@GetMapping("/public/profile")
	public String profile(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		return "/public/user-profile";
	}

}
