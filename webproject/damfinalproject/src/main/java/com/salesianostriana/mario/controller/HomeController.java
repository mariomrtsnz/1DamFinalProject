package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	HttpSession session;
	
	@GetMapping({ "/index", "/index.html" })
	public String indexPage() {
		session.setAttribute("loggedUser", null);
		return "index";
	}
}
