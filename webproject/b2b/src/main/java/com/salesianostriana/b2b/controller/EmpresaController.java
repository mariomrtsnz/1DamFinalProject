package com.salesianostriana.b2b.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.b2b.service.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;

	@GetMapping({"/" , "empresa/" , "/empresa"})
	public String pcUser () {
		return "empresa/pc_emp";
	}
	
	// Formulario Add Empresa
	
	
	
}
