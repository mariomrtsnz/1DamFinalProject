package com.salesianostriana.b2b.controller;
/*
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.b2b.formbean.LoginUser;
import com.salesianostriana.b2b.model.Distribuidor;
import com.salesianostriana.b2b.service.DistribuidorService;

@Controller */
public class LoginControllerD {/*

	@Autowired
	private DistribuidorService DistribuidorService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginUser", new LoginUser());
		return "login";

	}
	
	@PostMapping("/checkLogin")
	public String doLogin(@ModelAttribute("loginUser") LoginUser loginUser, BindingResult bindingResult, Model model) {

		Distribuidor user = DistribuidorService.login(loginUser.getUsuario(), loginUser.getPass());

		if (user instanceof Distribuidor) {
			session.setAttribute("usuarioActual", user);
			return "pc_dis";
		} else {
			model.addAttribute("loginError", "El usuario o contraseña no es válido");
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String doLogout(Model model) {
		session.setAttribute("usuarioActual", null);
		return "redirect:/";
	}*/
}
