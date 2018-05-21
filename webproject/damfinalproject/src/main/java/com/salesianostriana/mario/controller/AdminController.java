package com.salesianostriana.mario.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.mario.formbean.SignUpUser;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.model.Treatment;
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
	public String index(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-dashboard-index";
	}

	@GetMapping("/admin-services-list")
	public String servicesList(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("numberOfTreatments", treatmentService.calculateNumberOfItems());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-services-list";
	}

	@GetMapping("/admin-add-service")
	public String goToAddService(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newService", new Treatment());
		return "/admin/admin-add-service";
	}
	
	@PostMapping("/addNewService")
	public String submitSignUp(@ModelAttribute("newService") Treatment newService, BindingResult bindingResult,
			Model model) {
		Treatment treatment = new Treatment(newService.getDescription(), newService.getDiscount(), newService.isPaidInInstallments(), newService.getName(), newService.getNumSessions(), newService.getTotalPrice());
		treatmentService.save(treatment);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/admin-services-list";
	}

	@GetMapping("/admin-add-client")
	public String goToAddClient(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-add-client";
	}

	// @PostMapping("/addNewClient")
	// public String addClient() {
	// return "";
	// }

	@GetMapping("/admin-staff-list")
	public String staffList(Model model) {
		model.addAttribute("staff", employeeService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("numberOfEmployees", employeeService.calculateNumberOfItems());
		return "/admin/admin-staff-list";
	}

	@GetMapping("/admin-add-staff")
	public String goToAddStaff(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newEmployee", new Employee());
		return "/admin/admin-add-staff";
	}

	 @PostMapping("/addNewEmployee")
	 public String addStaff(@ModelAttribute("newEmployee") Employee newEmployee, BindingResult bindingResult,
				Model model) {
		 Employee employee = new Employee(newEmployee.getDni(), newEmployee.getEmail(), newEmployee.getGrossAnualSalary(), newEmployee.getName(), newEmployee.getPassword(), newEmployee.getPhone(), newEmployee.getProfilePic(), newEmployee.getPosition(), LocalDateTime.now());
			employeeService.save(employee);
		 model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		 return "redirect:/admin-staff-list";
	 }

	@GetMapping("/admin-calendar")
	public String showCalendar(Model model) {
		model.addAttribute("appointments", appointmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-calendar";
	}

	// @PostMapping("/admin-add-appointment")
	// public String addAppointment() {
	// return "";
	// }

}
