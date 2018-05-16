package com.salesianostriana.b2b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DistribuidorController {

	@GetMapping ("/pc_dis")
	public String pcDis() {
		return "pc_dis";
	}
	
	
	
}