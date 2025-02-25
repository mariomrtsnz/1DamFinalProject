package com.salesianostriana.mario.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.mario.model.Pager;
import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class TreatmentController {

	@Autowired
	HttpSession session;

	@Autowired
	TreatmentService treatmentService;
	
	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20};
    boolean showTreatmentsHistorical = false;

	@GetMapping("/admin-add-service")
	public String goToAddService(Model model) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		model.addAttribute("newService", new Treatment());
		return "/admin/admin-add-service";
	}

	@PostMapping("/addNewService")
	public String submitSignUp(@ModelAttribute("newService") Treatment newService, BindingResult bindingResult,
			Model model, RedirectAttributes ra) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		Treatment treatment = new Treatment(newService.getDescription(), newService.getDiscount(),
				newService.isPaidInInstallments(), newService.getName(), newService.getNumSessions(),
				newService.getTotalPrice());
		
		boolean invalidName = !treatment.getName().matches("^[\\p{L} .'-]+$");
		boolean invalidTotalPrice = !(treatment.getTotalPrice() >= 5);
		boolean invalidNumSessions = !(treatment.getNumSessions() >= 1);
		
		if(invalidName) {
			ra.addFlashAttribute("invalidName", invalidName);
			return "redirect:/admin-add-service";
		} else if(invalidTotalPrice) {
			ra.addFlashAttribute("invalidTotalPrice", invalidTotalPrice);
			return "redirect:/admin-add-service";
		} else if(invalidNumSessions) {
			ra.addFlashAttribute("invalidNumSessions", invalidNumSessions);
			return "redirect:/admin-add-service";
		} else {			
			treatmentService.save(treatment);
			return "redirect:/admin-services-list";
		}
	}

	@GetMapping("/delete-treatment/{id}")
	public String deleteTreatment(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
		Treatment treatment = treatmentService.findOneById(id);
		// companyService.findDefaultCompany().removeTreatment(treatment);
		// treatment.setCompany(null);
		// treatment.setAppointments(null);
		treatmentService.setHistoricalTrue(treatment);
		ra.addFlashAttribute("deleteSuccess", true);
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
			BindingResult bindingResult, RedirectAttributes ra) {
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		boolean invalidName = !editableTreatment.getName().matches("^[\\p{L} .'-]+$");
		// La descripción no tiene validación ya que quiero permitir que la descripción sea cualquier cosa.
		boolean invalidTotalPrice = !(editableTreatment.getTotalPrice() >= 5);
		boolean invalidNumSessions = !(editableTreatment.getNumSessions() >= 1);
		
		if(invalidName) {
			ra.addFlashAttribute("invalidName", invalidName);
		} else if(invalidTotalPrice) {
			ra.addFlashAttribute("invalidTotalPrice", invalidTotalPrice);
		} else if(invalidNumSessions) {
			ra.addFlashAttribute("invalidNumSessions", invalidNumSessions);
		} else {			
			treatmentService.edit(editableTreatment);
		}
		return "redirect:/admin-services-list";
	}
	
	@GetMapping("/admin-services-list")
	public String servicesList(@RequestParam("pageSize") Optional<Integer> pageSize, @RequestParam("page") Optional<Integer> page, Model model) {
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Treatment> treatments = treatmentService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(treatments.getTotalPages(), treatments.getNumber(), BUTTONS_TO_SHOW);

//		if (!showTreatmentsHistorical) {
//			model.addAttribute("treatments", treatmentService.findAll());
//		} else {
//			model.addAttribute("treatments", treatmentService.findAllHistorical());
//		}
		model.addAttribute("treatments", treatments);
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
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

	
}