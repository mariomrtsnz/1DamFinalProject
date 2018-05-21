package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.mario.service.AppointmentService;
import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.CompanyService;
import com.salesianostriana.mario.service.EmployeeService;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class ClientController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private ClientService service;

	@Autowired
	private TreatmentService treatmentService;

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping({ "/public", "/user-index" })
	public String index(Model model) {
		model.addAttribute("company", companyService.findDefaultCompany());
		model.addAttribute("numberOfClients", service.calculateNumberOfItems());
		model.addAttribute("numberOfPaidAppointments", appointmentService.calculateNumberOfPaidAppointments());
		model.addAttribute("numberOfActiveEmployees", employeeService.calculateNumberOfActiveEmployees());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-index";
	}

	// TODO: Remove "/public" from Mappings
	@GetMapping("/public/services")
	public String services(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-services";
	}

	@GetMapping("/public/aboutus")
	public String aboutUs(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-aboutus";
	}

	@GetMapping("/public/contactus")
	public String contactUs(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("company", companyService.findDefaultCompany());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-contactus";
	}

	@GetMapping("/public/profile")
	public String profile(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-profile";
	}

}
