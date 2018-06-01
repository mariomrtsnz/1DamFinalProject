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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.mario.formbean.AppointmentFormBean;
import com.salesianostriana.mario.formbean.SearchBean;
import com.salesianostriana.mario.model.Appointment;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.service.AdminService;
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
	
	@Autowired
	private AdminService adminService;

	@GetMapping({ "/public", "/user-index" })
	public String index(Model model) {
		model.addAttribute("company", companyService.findDefaultCompany());
		model.addAttribute("numberOfClients", service.calculateNumberOfItems());
		model.addAttribute("numberOfPaidAppointments", appointmentService.calculateNumberOfPaidAppointments());
		model.addAttribute("numberOfActiveEmployees", employeeService.calculateNumberOfActiveEmployees());
		model.addAttribute("allTreatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/public/user-index";
	}

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
		Client loggedClient = (Client) session.getAttribute("loggedUser");
		model.addAttribute("editableClient", service.findOne(loggedClient.getId()));
		return "/public/user-profile";
	}
	
	@PostMapping("/editUser")
	public String submitEditUser(@ModelAttribute("editableClient") Client editableClient, Model model, BindingResult bindingResult) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		service.edit(editableClient);
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
			BindingResult bindingResult, Model model, RedirectAttributes ra) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		LocalDateTime startDateTime = LocalDateTime.of(newAppointment.getStartDate(), newAppointment.getStartTime());
		
		Employee firstEmployeeAvailable = employeeService.findFirstAvailableByDateTime(startDateTime);
		
		boolean noEmployeesAvailable = firstEmployeeAvailable == null;
		Appointment appointment = null;

		if (noEmployeesAvailable) {
			ra.addFlashAttribute("noEmployeesAvailable", noEmployeesAvailable);
			return "redirect:/public/user-service/{id}";
		} else {
			appointment = new Appointment(startDateTime, (Client) session.getAttribute("loggedUser"),
					employeeService.findFirstAvailableByDateTime(startDateTime), startDateTime.plusHours(1), true,
					LocalDateTime.now(), treatmentService.findOneById(id));
			ra.addFlashAttribute("appointmentSuccess", true);
			appointmentService.save(appointment);
			return "redirect:/public/user-service/{id}";
		}
	}

	@RequestMapping(value = "/addNewAppointment/{id}", method = RequestMethod.POST, params = "action=payPhysically")
	public String addAppointmentAndPayPhysically(@PathVariable("id") Long id,
			@ModelAttribute("newAppointment") AppointmentFormBean newAppointment, BindingResult bindingResult,
			Model model, RedirectAttributes ra) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		LocalDateTime startDateTime = LocalDateTime.of(newAppointment.getStartDate(), newAppointment.getStartTime());
		
		Employee firstEmployeeAvailable = employeeService.findFirstAvailableByDateTime(startDateTime);

		boolean noEmployeesAvailable = firstEmployeeAvailable == null;
		Appointment appointment = null;
		
		if (noEmployeesAvailable) {
			ra.addFlashAttribute("noEmployeesAvailable", noEmployeesAvailable);
			return "redirect:/public/user-service/{id}";
		} else {
			appointment = new Appointment(startDateTime, (Client) session.getAttribute("loggedUser"),
					employeeService.findFirstAvailableByDateTime(startDateTime), startDateTime.plusHours(1), false,
					LocalDateTime.now(), treatmentService.findOneById(id));
			ra.addFlashAttribute("appointmentSuccess", true);
			appointmentService.save(appointment);
			return "redirect:/public/user-service/{id}";
		}
	}

	@GetMapping("/edit-client/{id}")
	public String goToEditClient(@PathVariable("id") Long id, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("editableClient", service.findOne(id));
		return "/admin/admin-edit-client";
	}

	@PostMapping("/editClient")
	public String editClient(@ModelAttribute("editableClient") Client editableClient, Model model,
			BindingResult bindingResult, RedirectAttributes ra) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		boolean invalidName = !editableClient.getName().matches("^[\\p{L} .'-]+$");
		boolean invalidPhone = !editableClient.getPhone().matches("^[679]\\d{8}");
		boolean invalidDni = !editableClient.getDni().matches("[0-9]{7,8}\\-?[A-z]{1}\\b");

		if(invalidName) {
			ra.addFlashAttribute("invalidName", invalidName);
		} else if(invalidPhone) {
			ra.addFlashAttribute("invalidPhone", invalidPhone);
		} else if(invalidDni) {
			ra.addFlashAttribute("invalidDni", invalidDni);
 		} else {
 			ra.addFlashAttribute("editSuccess", true);
 			service.edit(editableClient);
		}
		return "redirect:/staff-clients-list";
	}

	@GetMapping("/admin-add-client")
	public String goToAddClient(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newClient", new Client());
		return "/admin/admin-add-client";
	}

	@PostMapping("/addNewClient")
	public String addClient(@ModelAttribute("newClient") Client newClient, BindingResult bindingResult, Model model, RedirectAttributes ra) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		Client client = new Client(newClient.getDni(), newClient.getEmail(), newClient.getName(),
				newClient.getPassword(), newClient.getPhone(), newClient.getProfilePic(), LocalDateTime.now());
		
		boolean existingUserEmail = (service.findFirstByEmail(client.getEmail()) != null) || (employeeService.findFirstByEmail(client.getEmail()) != null) || (adminService.findFirstByEmail(client.getEmail()) != null);
		boolean existingUserDni = service.findFirstByDni(client.getDni()) != null;
		boolean invalidName = !client.getName().matches("^[\\p{L} .'-]+$");
		boolean invalidPhone = !client.getPhone().matches("^[679]\\d{8}");
		boolean invalidDni = !client.getDni().matches("[0-9]{7,8}\\-?[A-z]{1}\\b");
		

		if (existingUserEmail) {
			ra.addFlashAttribute("existingUserEmail", existingUserEmail);
			return "redirect:/admin-add-client";
		} else if(existingUserDni) {
			ra.addFlashAttribute("existingUserDni", existingUserDni);
			return "redirect:/admin-add-client";
		} else if(invalidName) {
			ra.addFlashAttribute("invalidName", invalidName);
			return "redirect:/admin-add-client";
		} else if(invalidPhone) {
			ra.addFlashAttribute("invalidPhone", invalidPhone);
			return "redirect:/admin-add-client";
		} else if(invalidDni) {
			ra.addFlashAttribute("invalidDni", invalidDni);
			return "redirect:/admin-add-client";
 		} else {
 			service.save(client);
 			ra.addFlashAttribute("addSuccess", true);
 			return "redirect:/staff-clients-list";
		}
	}

	@GetMapping("/delete-client/{id}")
	public String deleteClient(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
		Client client = service.findOne(id);
		boolean deleteSuccess = false;

		// Inutilizado a propósito ya que solo quiero ponerlo como histórico y no eliminarlo al completo de la BD.
		// companyService.findDefaultCompany().removeTreatment(treatment);
		// client.setCompany(null);
		// client.setAppointments(null);
		
		if (!client.isHistorical()) {
			service.setHistoricalTrue(client);
			deleteSuccess = true;
		}
		
		ra.addFlashAttribute("deleteSuccess", deleteSuccess);
		service.setHistoricalTrue(client);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/staff-clients-list";
	}
	
	@GetMapping("/myAppointments")
	public String showPersonalAppointments(Model model) {
		Client loggedClient = (Client) session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("myAppointments", service.findOne(loggedClient.getId()).getAppointments());
		model.addAttribute("allTreatments", treatmentService.findAll());
		return "/public/myAppointments";
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
