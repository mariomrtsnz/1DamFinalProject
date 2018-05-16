package com.salesianostriana.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	@GetMapping("/staff")
	public String a() {
		return "/staff/staff-dashboard";
	}
}
