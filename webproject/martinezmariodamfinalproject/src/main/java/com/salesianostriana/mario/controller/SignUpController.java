package com.salesianostriana.mario.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.mario.formbean.SignUpUser;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.service.AdminService;
import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.EmployeeService;

@Controller
public class SignUpController {
	@Autowired
	private HttpSession session;

	@Autowired
	private AdminService adminService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/public/signup.html")
	public String signUpPage(Model model) {
		model.addAttribute("signUpUser", new SignUpUser());
		return "/public/signup";
	}
	
	@PostMapping("/checkSignUp")
	public String submitSignUp(@ModelAttribute("signUpUser") SignUpUser signUpUser, BindingResult bindingResult, Model model) {
		// Añade los valores de logueo a un objeto Cliente porque solo se registran clientes desde esa ventana.
		Client client = new Client(signUpUser.getDni(), signUpUser.getEmail(), signUpUser.getName(),
				signUpUser.getPassword(), signUpUser.getPhone(), LocalDateTime.now());

		// Comprobación de que ya existe un usuario con ese correo que se ha ingresado en el formulario de registro
		boolean existingUserEmail = (clientService.findFirstByEmail(signUpUser.getEmail()) != null) || (employeeService.findFirstByEmail(signUpUser.getEmail()) != null) || (adminService.findFirstByEmail(signUpUser.getEmail()) != null);
		// Comprobación de que ya existe un usuario con ese DNI que se ha ingresado en el formulario de registro
		boolean existingUserDni = clientService.findFirstByDni(signUpUser.getDni()) != null;
		// Letras comienzan en mayúscula, sin números ni símbolos, acepta todos los acentos y multiples nombres (siempre que empiecen por mayúscula de nuevo) 
		boolean invalidName = !signUpUser.getName().matches("([A-ZÀ-Ú]{1}[A-Za-zÀ-ú]{1,}(-| ){0,1})");
		// Prefijos: 6, 7 o 9 seguido de 8 números cualesquiera.
		boolean invalidPhone = !signUpUser.getPhone().matches("^[679]\\d{8}");
		// DNI Español, no tiene por qué coincidir el cálculo para facilitar a la hora de probar el registro.
		boolean invalidDni = !signUpUser.getDni().matches("[0-9]{7,8}\\-?[A-z]{1}\\b");
		

		// Si existe el email, añado al modelo el mensaje de error de email, si existe el dni, añado al modelo el mensaje de error de DNI, y si no se cumple ninguno de los dos, guardo el Cliente en la BD.
		if (existingUserEmail) {
			model.addAttribute("existingUserEmail", existingUserEmail);
		} else if(existingUserDni) {
			model.addAttribute("existingUserDni", existingUserDni);
		} else if(invalidName) {
			model.addAttribute("invalidName", invalidName);
		} else if(invalidPhone) {
			model.addAttribute("invalidPhone", invalidPhone);
		} else if(invalidDni) {
			model.addAttribute("invalidDni", invalidDni);
		}
		else {
			clientService.save(client);
			session.setAttribute("loggedUser", client);
		}
		return "/index";
	}
	
}
