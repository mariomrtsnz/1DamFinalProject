package com.salesianostriana.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/index", "/index.html" })
	public String indexPage() {
		return "index";
	}
}
