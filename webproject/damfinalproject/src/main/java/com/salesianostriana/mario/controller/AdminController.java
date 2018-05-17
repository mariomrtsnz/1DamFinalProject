package com.salesianostriana.mario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class AdminController {

	@Autowired
	private TreatmentService treatmentService;

	@GetMapping("/admin-dashboard")
	public String index() {
		return "/admin/admin-dashboard-index";
	}

	@GetMapping("/admin-services-list")
	public String servicesList(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		return "/admin/admin-services-list";
	}

	@GetMapping("/admin-add-service")
	public String addService() {
		return "/admin/admin-add-service";
	}
}
