package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/staff")
	public String a(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/staff/staff-dashboard";
	}
	
	@GetMapping("/staff-schedule")
	public String schedule(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/staff/staff-schedule";
	}
	
	@GetMapping("/staff-clients-list")
	public String clientsList(Model model) {
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("numberOfClients", clientService.calculateNumberOfItems());
		return "/staff/staff-clients-list";
	}
}
