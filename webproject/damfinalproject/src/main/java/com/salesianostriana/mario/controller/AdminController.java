package com.salesianostriana.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping({ "/admin", "/admin-dashboard-index.html" })
	public String a() {
		return "/admin/admin-dashboard-index";
	}
}
