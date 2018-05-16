package com.salesianostriana.b2b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {

	@GetMapping("/pc_emp")
	public String pcUser () {
		return "pc_emp";
	}
	
}
