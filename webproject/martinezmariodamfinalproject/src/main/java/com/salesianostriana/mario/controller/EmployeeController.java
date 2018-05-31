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

import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.service.AdminService;
import com.salesianostriana.mario.service.AppointmentService;
import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.CompanyService;
import com.salesianostriana.mario.service.EmployeeService;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class EmployeeController {

	@Autowired
	private HttpSession session;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TreatmentService treatmentService;
	
	boolean showClientsHistorical = false, filterByDuePayment = false, filterByPaidAppointment = false;

	@GetMapping("/staff")
	public String a(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/staff/staff-dashboard";
	}

	@GetMapping("/staff-schedule")
	public String schedule(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		Employee loggedEmployee = (Employee) session.getAttribute("loggedUser");
		Iterable<Appointment> appointments = appointmentService.findByEmployee(loggedEmployee);
		Iterable <Appointment> paidAppointmentsOfEmployee = appointmentService.findByEmployeeAndPaidTrue(loggedEmployee);
		if (!filterByPaidAppointment) {
			model.addAttribute("appointments", appointments);
		} else {
			model.addAttribute("appointments", paidAppointmentsOfEmployee);
		}
		model.addAttribute("numberOfAppointments", appointmentService.calculateNumberOfItems(appointments));
		model.addAttribute("filterByPaidAppointment", filterByPaidAppointment);
		return "/staff/staff-schedule";
	}

	@GetMapping("/staff-clients-list")
	public String clientsList(Model model) {
		if (!showClientsHistorical) {
			model.addAttribute("clients", clientService.findAll());
		} 
		else if (filterByDuePayment) {
			model.addAttribute("clients", clientService.findByDuePayment());
		}
		else{
			model.addAttribute("clients", clientService.findAllHistorical());
		}
		model.addAttribute("showClientsHistorical", showClientsHistorical);
		model.addAttribute("filterByDuePayment", filterByDuePayment);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("numberOfClients", clientService.calculateNumberOfItems());
		return "/staff/staff-clients-list";
	}
	
	@GetMapping("/showClientsHistorical")
	public String showClientsHistorical() {
		if (showClientsHistorical) {
			showClientsHistorical = false;
		} else {
			showClientsHistorical = true;
		}
		return "redirect:/staff-clients-list";
	}

	@GetMapping("/filterByDuePayment")
	public String filterByDuePayment() {
		if (filterByDuePayment) {
			filterByDuePayment = false;
		} else {
			filterByDuePayment = true;
		}
		return "redirect:/staff-clients-list";
	}
	
	@GetMapping("/staffFilterByPaidAppointment")
	public String staffFilterByPaidAppointment() {
		if (filterByPaidAppointment) {
			filterByPaidAppointment = false;
		} else {
			filterByPaidAppointment = true;
		}
		return "redirect:/staff-schedule";
	}
	
	@GetMapping("/admin-add-staff")
	public String goToAddStaff(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newEmployee", new Employee());
		return "/admin/admin-add-staff";
	}

	@PostMapping("/addNewEmployee")
	public String addStaff(@ModelAttribute("newEmployee") Employee newEmployee, BindingResult bindingResult,
			Model model, RedirectAttributes ra) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		Employee employee = new Employee(newEmployee.getDni(), newEmployee.getEmail(),
				newEmployee.getGrossAnualSalary(), newEmployee.getName(), newEmployee.getPassword(),
				newEmployee.getPhone(), newEmployee.getProfilePic(), newEmployee.getPosition(), LocalDateTime.now(),
				null);
		
		boolean existingUserEmail = (clientService.findFirstByEmail(employee.getEmail()) != null) || (employeeService.findFirstByEmail(employee.getEmail()) != null) || (adminService.findFirstByEmail(employee.getEmail()) != null);
		boolean existingUserDni = clientService.findFirstByDni(employee.getDni()) != null;
		boolean invalidName = !employee.getName().matches("([A-ZÀ-Ú]{1}[A-Za-zÀ-ú]{1,}(-| ){0,1})");
		boolean invalidPhone = !employee.getPhone().matches("^[679]\\d{8}");
		boolean invalidDni = !employee.getDni().matches("[0-9]{7,8}\\-?[A-z]{1}\\b");
		boolean invalidSalary = !(employee.getGrossAnualSalary()>10302.60);
		

		if (existingUserEmail) {
			ra.addFlashAttribute("existingUserEmail", existingUserEmail);
			return "redirect:/admin-add-staff";
		} else if(existingUserDni) {
			ra.addFlashAttribute("existingUserDni", existingUserDni);
			return "redirect:/admin-add-staff";
		} else if(invalidName) {
			ra.addFlashAttribute("invalidName", invalidName);
			return "redirect:/admin-add-staff";
		} else if(invalidPhone) {
			ra.addFlashAttribute("invalidPhone", invalidPhone);
			return "redirect:/admin-add-staff";
		} else if(invalidDni) {
			ra.addFlashAttribute("invalidDni", invalidDni);
			return "redirect:/admin-add-staff";
 		} else if(invalidSalary) {
 			ra.addFlashAttribute("invalidSalary", invalidSalary);
			return "redirect:/admin-add-staff";
 		}
		else {
			employeeService.save(employee);
			return "redirect:/admin-staff-list";
		}
	}

	@GetMapping("/edit-staff/{id}")
	public String goToEditStaff(@PathVariable("id") Long id, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("editableEmployee", employeeService.findOne(id));
		return "/admin/admin-edit-staff";
	}

	@PostMapping("/editEmployee")
	public String editEmployee(@ModelAttribute("editableEmployee") Employee editableEmployee, Model model,
			BindingResult bindingResult) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		employeeService.edit(editableEmployee);
		return "redirect:/admin-staff-list";
	}

	@GetMapping("/delete-employee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
		Employee employee = employeeService.findOne(id);
		boolean deleteSuccess = false;
		// Inutilizado a propósito ya que solo quiero ponerlo como histórico y no eliminarlo al completo de la BD.
		// employeeService.remove(employee);
		if (!employee.isHistorical()) {
			employeeService.setHistoricalTrue(employee);
			deleteSuccess = true;
		}

		ra.addFlashAttribute("deleteSuccess", deleteSuccess);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/admin-staff-list";
	}
	
	@GetMapping("/staff/profile")
	public String staffProfile(Model model) {
		model.addAttribute("allTreatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		Employee loggedEmployee = (Employee) session.getAttribute("loggedUser");
		model.addAttribute("editableEmployee", employeeService.findOne(loggedEmployee.getId()));
		return "/public/user-profile";
	}
	
	@PostMapping("/editStaff")
	public String submitEditStaff(@ModelAttribute("editableEmployee") Employee editableEmployee, BindingResult bindingResult, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		employeeService.edit(editableEmployee);
		return "redirect:/staff/profile";
	}
}
