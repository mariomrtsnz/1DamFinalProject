package com.salesianostriana.mario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.CompanyService;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class ClientController {

	@Autowired
	private ClientService service;
	
	@Autowired
	private TreatmentService treatmentService;
	
	@Autowired
	private CompanyService companyService;

	@GetMapping("/public")
	public String index(Model model) {
		model.addAttribute("company", companyService.findDefaultCompany());
		return "/public/user-index";
	}
	
//	@GetMapping("/public")
//	public String index(Model model) {
//		model.addAttribute(loggedUser);
//		return "/public/user-index";
//	}
	
	@GetMapping("/public/services")
	public String services(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		return "/public/user-services";
	}
	
	@GetMapping("/public/aboutus")
	public String aboutUs(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		return "/public/user-aboutus";
	}
	
	@GetMapping("/public/contactus")
	public String contactUs(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("company", companyService.findDefaultCompany());
		return "/public/user-contactus";
	}
	
	@GetMapping("/public/profile")
	public String profile(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		return "/public/user-profile";
	}

}
