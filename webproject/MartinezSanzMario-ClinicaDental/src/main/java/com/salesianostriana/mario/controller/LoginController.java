package com.salesianostriana.mario.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.mario.formbean.LoginUser;
import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.service.AdminService;
import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.EmployeeService;

// Controller para el logueo de la pantalla inicial, obligatorio iniciar sesión para entrar en la página.
// Usuarios principales (email - contraseña):
// Tipo Empleado: empleado@empleado.com - empleado
// Tipo Usuario: usuario@usuario.com - 1234
// Tipo Admin: admin@admin.com - admin
@Controller
public class LoginController {

	@Autowired
	private HttpSession session;

	@Autowired
	private AdminService adminService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ClientService clientService;

	@GetMapping("/public/login.html")
	public String loginPage(Model model) {
		model.addAttribute("loginUser", new LoginUser());
		return "/public/login";
	}

	@PostMapping("/checkLogin")
	public String submitLogin(@ModelAttribute("loginUser") LoginUser loginUser, BindingResult bindingResult,
			Model model) {
		Admin user = adminService.login(loginUser.getEmail(), loginUser.getPassword());
		Client userClient = clientService.login(loginUser.getEmail(), loginUser.getPassword());
		Employee userEmployee = employeeService.login(loginUser.getEmail(), loginUser.getPassword());

		if (user instanceof Admin) {
			session.setAttribute("loggedUser", user);
			return "redirect:/admin-dashboard";
		} else if (userClient instanceof Client) {
			session.setAttribute("loggedUser", userClient);
			return "redirect:/public";
		} else if (userEmployee instanceof Employee) {
			session.setAttribute("loggedUser", userEmployee);
			return "redirect:/staff";
		} else {
			model.addAttribute("loginError", true);
			return "/index";
		}
	}
}
