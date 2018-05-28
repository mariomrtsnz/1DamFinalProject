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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.salesianostriana.mario.formbean.AppointmentFormBean;
import com.salesianostriana.mario.formbean.SearchBean;
import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.model.Treatment;
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
	
	boolean selected = false;

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
		model.addAttribute("allTreatments", treatmentService.findAll());
		model.addAttribute("filteredTreatments", treatmentService.findAll());
		model.addAttribute("search", new SearchBean());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-services";
	}

	@GetMapping("/public/aboutus")
	public String aboutUs(Model model) {
		model.addAttribute("allTreatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("staff", employeeService.findAllActive());
		model.addAttribute("company", companyService.findDefaultCompany());
		return "/public/user-aboutus";
	}

	@GetMapping("/public/contactus")
	public String contactUs(Model model) {
		model.addAttribute("allTreatments", treatmentService.findAll());
		model.addAttribute("company", companyService.findDefaultCompany());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-contactus";
	}

	@GetMapping("/public/profile")
	public String profile(Model model) {
		model.addAttribute("allTreatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		if (session.getAttribute("loggedUser") instanceof Client) {
			model.addAttribute("editableUser", new Client());	
		} else if (session.getAttribute("loggedUser") instanceof Employee) {
			model.addAttribute("editableUser", new Employee());
		} else {
			model.addAttribute("editableUser", new Admin());
		}
		return "/public/user-profile";
	}
	
	@PostMapping("/editUser")
	public String submitEditUser(@ModelAttribute("editableUser") Client editableClient, BindingResult bindingResult, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
//		service.edit(editableUser);
		return "redirect:/public/profile";
	}

	@GetMapping("/public/user-service/{id}")
	public String serviceDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("allTreatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newAppointment", new AppointmentFormBean());
		Treatment s = treatmentService.findOneById(id);
		if (s != null) {
			model.addAttribute("selectedTreatment", s);
			model.addAttribute("totalPriceWithDiscount", treatmentService.calculatePriceWithDiscount(s));
			return "/public/user-service";
		} else {
			// Tratamiento del error
			return "Error";
		}
	}

	@RequestMapping(value = "/addNewAppointment/{id}", method = RequestMethod.POST, params = "action=payNow")
	public String addAppointmentAndPayNow(@PathVariable("id") Long id, @ModelAttribute("newAppointment") AppointmentFormBean newAppointment,
			BindingResult bindingResult, Model model) {
		LocalDateTime startDateTime = LocalDateTime.of(newAppointment.getStartDate(), newAppointment.getStartTime());
		Employee firstEmployeeAvailable = employeeService.findFirstAvailableByDateTime(startDateTime);
		boolean noEmployeesAvailable = false;
		Appointment appointment = null;
		if (firstEmployeeAvailable == null) {
			noEmployeesAvailable = true;
		} else {			
			appointment = new Appointment(startDateTime, (Client) session.getAttribute("loggedUser"),
					employeeService.findFirstAvailableByDateTime(startDateTime), startDateTime.plusHours(1), true,
					LocalDateTime.now(), treatmentService.findOneById(id));
		}
		if (noEmployeesAvailable) {			
			return "redirect:/public/user-service/{id}";
		} else {
			model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
			appointmentService.save(appointment);
			return "redirect:/public/user-service/{id}";
		}
	}

	@RequestMapping(value = "/addNewAppointment/{id}", method = RequestMethod.POST, params = "action=payPhysically")
	public String addAppointmentAndPayPhysically(@PathVariable("id") Long id,
			@ModelAttribute("newAppointment") AppointmentFormBean newAppointment, BindingResult bindingResult,
			Model model) {
		LocalDateTime startTime = LocalDateTime.of(newAppointment.getStartDate(), newAppointment.getStartTime());
		Appointment appointment = new Appointment(startTime, (Client) session.getAttribute("loggedUser"),
				employeeService.findFirstAvailableByDateTime(startTime), startTime.plusHours(1), false,
				LocalDateTime.now(), treatmentService.findOneById(id));
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		appointmentService.save(appointment);
		return "redirect:/public/user-service/{id}";
	}

	@GetMapping("/edit-client/{id}")
	public String goToEditClient(@PathVariable("id") Long id, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("editableClient", service.findOne(id));
		return "/admin/admin-edit-client";
	}

	@PostMapping("/editClient")
	public String editClient(@ModelAttribute("editableClient") Client editableClient, Model model,
			BindingResult bindingResult) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		service.edit(editableClient);
		return "redirect:/staff-clients-list";
	}

	@GetMapping("/admin-add-client")
	public String goToAddClient(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newClient", new Client());
		return "/admin/admin-add-client";
	}

	@PostMapping("/addNewClient")
	public String addClient(@ModelAttribute("newClient") Client newClient, BindingResult bindingResult, Model model) {
		Client client = new Client(newClient.getDni(), newClient.getEmail(), newClient.getName(),
				newClient.getPassword(), newClient.getPhone(), newClient.getProfilePic(), LocalDateTime.now());
		service.save(client);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/staff-clients-list";
	}

	@GetMapping("/delete-client/{id}")
	public String deleteClient(@PathVariable("id") Long id, Model model) {
		Client client = service.findOne(id);
		// companyService.findDefaultCompany().removeTreatment(treatment);
		// treatment.setCompany(null);
		// treatment.setAppointments(null);
		service.setHistoricalTrue(client);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/staff-clients-list";
	}
	
	@PostMapping("/search")
	  public String searchTreatment(@ModelAttribute("search") SearchBean searchBean,
			 Model model){
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("filteredTreatments", treatmentService.findByName(searchBean.getSearch()));
		model.addAttribute("allTreatments", treatmentService.findAll());
		return "/public/user-services";
	  }

}
