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

import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.CompanyService;
import com.salesianostriana.mario.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private HttpSession session;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private CompanyService companyService;
	
	boolean showClientsHistorical = false;

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
		if (!showClientsHistorical) {
			model.addAttribute("clients", clientService.findAll());
		} else {
			model.addAttribute("clients", clientService.findAllHistorical());
		}
		model.addAttribute("showClientsHistorical", showClientsHistorical);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("numberOfClients", clientService.calculateNumberOfItems());
		return "/staff/staff-clients-list";
	}
	
	@GetMapping("/showClientsHistorical")
	public String showClientsHistorical() {
		showClientsHistorical = true;
		return "redirect:/staff-clients-list";
	}
	
	@GetMapping("/removeClientsHistorical")
	public String removeClientsHistorical() {
		showClientsHistorical = false;
		return "redirect:/staff-clients-list";
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
		Employee employee = new Employee(newEmployee.getDni(), newEmployee.getEmail(),
				newEmployee.getGrossAnualSalary(), newEmployee.getName(), newEmployee.getPassword(),
				newEmployee.getPhone(), newEmployee.getProfilePic(), newEmployee.getPosition(), LocalDateTime.now(),
				null);
		employeeService.save(employee);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/admin-staff-list";
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
		// employeeService.remove(employee);
		if (!employee.isHistorical()) {
			employeeService.setHistoricalTrue(employee);
			deleteSuccess = true;
		}
		// TODO: Implement this so that toastr shows a deletion successful message after
		// redirect (On AdminController)
		ra.addAttribute("deleteSuccess", deleteSuccess);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/admin-staff-list";
	}
}
