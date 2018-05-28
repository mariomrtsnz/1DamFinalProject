package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class TreatmentController {

	@Autowired
	HttpSession session;

	@Autowired
	TreatmentService treatmentService;

	@GetMapping("/admin-add-service")
	public String goToAddService(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newService", new Treatment());
		return "/admin/admin-add-service";
	}

	@PostMapping("/addNewService")
	public String submitSignUp(@ModelAttribute("newService") Treatment newService, BindingResult bindingResult,
			Model model) {
		Treatment treatment = new Treatment(newService.getDescription(), newService.getDiscount(),
				newService.isPaidInInstallments(), newService.getName(), newService.getNumSessions(),
				newService.getTotalPrice());
		treatmentService.save(treatment);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/admin-services-list";
	}

	@GetMapping("/delete-treatment/{id}")
	public String deleteTreatment(@PathVariable("id") Long id, Model model) {
		Treatment treatment = treatmentService.findOneById(id);
		// companyService.findDefaultCompany().removeTreatment(treatment);
		// treatment.setCompany(null);
		// treatment.setAppointments(null);
		treatmentService.setHistoricalTrue(treatment);
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		return "redirect:/admin-services-list";
	}

	@GetMapping("/edit-treatment/{id}")
	public String goToEditTreatment(@PathVariable("id") Long id, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("editableTreatment", treatmentService.findOneById(id));
		return "/admin/admin-edit-treatment";
	}

	@PostMapping("/editTreatment")
	public String editTreatment(@ModelAttribute("editableTreatment") Treatment editableTreatment, Model model,
			BindingResult bindingResult) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		treatmentService.edit(editableTreatment);
		return "redirect:/admin-services-list";
	}

	// @GetMapping("/public/user-service/{id}")
	// public String serviceDetail(@PathVariable("id") Long id, Model model) {
	// model.addAttribute("treatments", treatmentService.findAll());
	// model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
	//
	// Treatment s = treatmentService.findOneById(id);
	// if (s != null) {
	// model.addAttribute("selectedTreatment", s);
	// model.addAttribute("totalPriceWithDiscount",
	// treatmentService.calculatePriceWithDiscount(s));
	// return "/public/user-service";
	// } else {
	// // Tratamiento del error
	// return "Error";
	// }
	// }
}