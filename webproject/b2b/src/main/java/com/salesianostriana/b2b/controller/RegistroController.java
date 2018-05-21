package com.salesianostriana.b2b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.b2b.model.Empresa;
import com.salesianostriana.b2b.service.EmpresaService;

@Controller
public class RegistroController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/registro")
	public String showRegisterForm (Model model) {
		model.addAttribute("formularioRegistro" , new Empresa () );
		return "form_reg.html";
	}
	
	@PostMapping ("/addEmpresa") 
	public String submit(@ModelAttribute ("formularioRegistro")Empresa empresa, Model model) {
		
		empresaService.save(empresa);
		return "redirect:/login";
	}	
}
