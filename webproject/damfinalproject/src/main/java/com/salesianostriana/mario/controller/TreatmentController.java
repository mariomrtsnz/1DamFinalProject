package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class TreatmentController {

	@Autowired
	HttpSession session;
	
	@Autowired
	TreatmentService treatmentService = new TreatmentService();

	@GetMapping("/public/user-service/{id}")
	public String serviceDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("treatments", treatmentService.findAll());
		model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
		
		Treatment s = treatmentService.findOneById(id);
		if (s != null) {
			model.addAttribute("selectedTreatment", s);
			return "/public/user-service";
		} else {
			// Tratamiento del error
			return "Error";
		}
	}

//	@PostMapping("/addTreatment")
//	public String submit(@ModelAttribute("FormService") Model model) {
//		return "";
//	}
//
//	public void process(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext,
//			TemplateEngine templateEngine) {
//		Iterable<Treatment> allTreatments = treatmentService.findAll();
//		
//		WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
//		ctx.setVariable("treatments", allTreatments);
//		
//		templateEngine.process("/admin/admin-services-list", ctx, response.getWriter());
//	}
}