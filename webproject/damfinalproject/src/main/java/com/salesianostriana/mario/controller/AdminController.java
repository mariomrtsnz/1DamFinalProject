package com.salesianostriana.mario.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

import com.salesianostriana.mario.formbean.AppointmentFormBean;
import com.salesianostriana.mario.formbean.SignUpUser;
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

	boolean showTreatmentsHistorical = false, showStaffHistorical = false, filterByPaidAppointment = false;

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
		if (showTreatmentsHistorical) {
			showTreatmentsHistorical  = false;
		} else {
			showTreatmentsHistorical  = true;
		}
		
		return "redirect:/admin-services-list";
	}

	@GetMapping("/admin-staff-list")
	public String staffList(Model model) {
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
	public String showStaffHistorical() {
		if (showStaffHistorical) {
			showStaffHistorical = false;
		} else {
			showStaffHistorical = true;
		}
		return "redirect:/admin-staff-list";
	}

	@GetMapping("/admin-calendar")
	public String showCalendar(Model model) {
		if (!filterByPaidAppointment) {
			model.addAttribute("appointments", appointmentService.findAll());
		} else {
			model.addAttribute("appointments", appointmentService.findAllPaid());
		}
		model.addAttribute("filterByPaidAppointment", filterByPaidAppointment);
		model.addAttribute("numberOfAppointments", appointmentService.calculateNumberOfItems());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "/admin/admin-calendar";
	}
	
	@GetMapping("/filterByPaidAppointment")
	public String filterByPaidAppointment(Model model) {
		if (filterByPaidAppointment) {
			filterByPaidAppointment = false;
		} else {
			filterByPaidAppointment = true;
		}
		return "redirect:/admin-calendar";
	}

	 @GetMapping("/admin-add-appointment")
	 public String addAppointment(Model model) {
		 model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		 model.addAttribute("newAppointment", new Appointment());
		 model.addAttribute("appointmentFormBean", new AppointmentFormBean());
		 model.addAttribute("clients", clientService.findAllActive());
		 model.addAttribute("employees", employeeService.findAllActive());
		 model.addAttribute("treatments", treatmentService.findAllActive());
		 return "/admin/admin-add-appointment";
	 }
	 
	 @PostMapping("/addNewAppointment")
	 public String submitNewAppointment(@ModelAttribute("newAppointment") Appointment newAppointment, @ModelAttribute("appointmentFormBean") AppointmentFormBean appointmentFormBean, BindingResult bindingResult, Model model) {
		 LocalDateTime startDateTime = LocalDateTime.of(appointmentFormBean.getStartDate(), appointmentFormBean.getStartTime());
//		 Employee employee = employeeService.findOne(newAppointment.getEmployee());
		 Appointment appointment = new Appointment(startDateTime, newAppointment.getClient(), newAppointment.getEmployee(), startDateTime.plusHours(1), false, LocalDateTime.now(), newAppointment.getTreatment());
		 model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		 appointmentService.save(appointment);
		 return "redirect:/admin-calendar";
	 }
	 
	 @GetMapping("/edit-appointment/{id}")
	 public String goToEditAppointment(@PathVariable("id") Long id, Model model) {
		 model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
			model.addAttribute("editableAppointment", appointmentService.findOne(id));
		 return "/admin/edit-appointment";
	 }
	 
	 @PostMapping("/editAppointment")
		public String editAppointment(@ModelAttribute("editableAppointment") Appointment editableAppointment, Model model,
				BindingResult bindingResult) {
			model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
			appointmentService.edit(editableAppointment);
			return "redirect:/admin-calendar";
		}
	 
	 @GetMapping("/delete-appointment/{id}")
		public String deleteAppointment(@PathVariable("id") Long id, Model model) {
			Appointment appointment = appointmentService.findOne(id);
			// companyService.findDefaultCompany().removeTreatment(treatment);
			// treatment.setCompany(null);
			// treatment.setAppointments(null);
			appointmentService.remove(appointment);
			model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
			return "redirect:/admin-calendar";
		}

}
