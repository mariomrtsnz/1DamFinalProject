package com.salesianostriana.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/", "/index.html" })
	public String indexPage() {
		return "index";
	}

	@GetMapping("/public/signup.html")
	public String signUpPage() {
		return "/public/signup";
	}

	@GetMapping("/public/login.html")
	public String loginPage() {
		return "/public/login";
	}
}
