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

import com.salesianostriana.mario.formbean.SignUpUser;
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

	boolean showTreatmentsHistorical = false;
	boolean showStaffHistorical = false;
	boolean showClientsHistorical = false;

	@GetMapping({ "/admin", "/admin-dashboard" })
	public String index(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		// boolean deleteSuccess = (boolean) model.getAttribute("deleteSuccess");
		// deleteSuccess = false;
		// model.addAttribute("deleteSuccess", deleteSuccess);
		return "/admin/admin-dashboard-index";
	}

	@GetMapping("/admin-services-list")
	public String servicesList(Model model) {
		if (!showTreatmentsHistorical) {
			model.addAttribute("treatments", treatmentService.findAll());
		} else {
			model.addAttribute("treatments", treatmentService.findAllHistorical());
		}
		model.addAttribute("showTreatmentsHistorical", showTreatmentsHistorical);
		model.addAttribute("numberOfTreatments", treatmentService.calculateNumberOfItems());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-services-list";
	}

	@GetMapping("/showTreatmentsHistorical")
	public String showTreatmentsHistorical(Model model) {
		showTreatmentsHistorical = true;
		return "redirect:/admin-services-list";
	}
	
	@GetMapping("/removeTreatmentsHistorical")
	public String removeTreatmentsHistorical(Model model) {
		showTreatmentsHistorical = false;
		return "redirect:/admin-services-list";
	}

	@GetMapping("/admin-staff-list")
	public String staffList(Model model, RedirectAttributes re) {
		if (!showStaffHistorical) {
			model.addAttribute("staff", employeeService.findAll());
		} else {
			model.addAttribute("staff", employeeService.findAllHistorical());
		}
		model.addAttribute("showStaffHistorical", showStaffHistorical);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("numberOfEmployees", employeeService.calculateNumberOfItems());
		// TODO: Implement this so that toastr shows a deletion successful message after
		// redirect (From EmployeeController)
		// boolean deleteSuccess = re.getFlashAttributes("deleteSuccess");
		// model.addAttribute("deleteSuccess", deleteSuccess);
		return "/admin/admin-staff-list";
	}
	
	@GetMapping("/showStaffHistorical")
	public String showStaffHistorical(Model model) {
		showStaffHistorical = true;
		return "redirect:/admin-staff-list";
	}
	
	@GetMapping("/removeStaffHistorical")
	public String removeStaffHistorical(Model model) {
		showStaffHistorical = false;
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
