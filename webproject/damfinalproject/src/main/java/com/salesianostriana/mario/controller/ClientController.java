package com.salesianostriana.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

	@GetMapping("/public")
	public String a() {
		return "/public/user-index";
	}
}
