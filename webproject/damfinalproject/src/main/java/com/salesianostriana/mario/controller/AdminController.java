package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.mario.service.AppointmentService;
import com.salesianostriana.mario.service.CompanyService;
import com.salesianostriana.mario.service.EmployeeService;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class AdminController {
	
	@Autowired
	HttpSession session;

	@Autowired
	private TreatmentService treatmentService;

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping({ "/admin", "/admin-dashboard" })
	public String index() {
		return "/admin/admin-dashboard-index";
	}

	@GetMapping("/admin-services-list")
	public String servicesList(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-services-list";
	}

	@GetMapping("/admin-add-service")
	public String goToAddService(Model modle) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-add-service";
	}

	// @PostMapping("/admin-add-service")
	// public String addService() {
	// return "";
	// }

	@GetMapping("/admin-add-client")
	public String goToAddClient(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-add-client";
	}

	// @PostMapping("/admin-add-client")
	// public String addClient() {
	// return "";
	// }

	@GetMapping("/admin-staff-list")
	public String staffList(Model model) {
		model.addAttribute("staff", employeeService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-staff-list";
	}

	@GetMapping("/admin-add-staff")
	public String goToAddStaff(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-add-staff";
	}

	// @PostMapping("/admin-add-staff")
	// public String addStaff() {
	// return "";
	// }

	@GetMapping("/admin-calendar")
	public String showCalendar(Model model) {
		model.addAttribute("appointments", appointmentService.findAll());
		return "/admin/admin-calendar";
	}

	// @PostMapping("/admin-add-appointment")
	// public String addAppointment() {
	// return "";
	// }

}
