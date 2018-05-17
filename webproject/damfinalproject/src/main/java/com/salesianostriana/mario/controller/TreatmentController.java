package com.salesianostriana.mario.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.service.TreatmentService;

@Controller
public class TreatmentController {

	TreatmentService treatmentService = new TreatmentService();

	@GetMapping("/service/{id}")
	public String serviceDetail(@PathVariable("id") long id, Model model) {
		Treatment s = treatmentService.findOneById(id);
		if (s != null) {
			model.addAttribute("service", s);
			return "ServiceDetail";
		} else {
			// Tratamiento del error
			return "Error";
		}
	}

//	@PostMapping("/addService")
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