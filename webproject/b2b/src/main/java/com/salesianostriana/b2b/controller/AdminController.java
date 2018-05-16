package com.salesianostriana.b2b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping ("/pc_admin")
	public String pcAdmin () {
		return "pc_admin";
	}
	
	@GetMapping ("/PC_ADMIN")
	public String pcAdmin2 () {
		return "pc_admin";
	}
	
	
	
}
