package com.salesianostriana.mario.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.service.AppointmentService;
import com.salesianostriana.mario.service.ClientService;
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

	@Autowired
	private ClientService clientService;

	@GetMapping({ "/admin", "/admin-dashboard" })
	public String index(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
//		boolean deleteSuccess = (boolean) model.getAttribute("deleteSuccess");
//		deleteSuccess = false;
//		model.addAttribute("deleteSuccess", deleteSuccess);
		return "/admin/admin-dashboard-index";
	}

	@GetMapping("/admin-services-list")
	public String servicesList(Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("numberOfTreatments", treatmentService.calculateNumberOfItems());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-services-list";
	}

	@GetMapping("/admin-staff-list")
	public String staffList(Model model, RedirectAttributes re) {
		model.addAttribute("staff", employeeService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("numberOfEmployees", employeeService.calculateNumberOfItems());
		//TODO: Implement this so that toastr shows a deletion successful message after redirect (From EmployeeController)
//		boolean deleteSuccess = re.getFlashAttributes("deleteSuccess");
//		model.addAttribute("deleteSuccess", deleteSuccess);
		return "/admin/admin-staff-list";
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
