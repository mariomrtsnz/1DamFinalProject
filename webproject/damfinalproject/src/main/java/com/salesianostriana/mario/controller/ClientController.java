package com.salesianostriana.mario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.mario.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping("/public")
	public String a() {
		return "/public/user-index";
	}

}
