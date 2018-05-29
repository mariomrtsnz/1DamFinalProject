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

import com.salesianostriana.mario.formbean.LoginUser;
import com.salesianostriana.mario.formbean.SignUpUser;
import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;
import com.salesianostriana.mario.service.AdminService;
import com.salesianostriana.mario.service.ClientService;
import com.salesianostriana.mario.service.EmployeeService;

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

	@GetMapping("/public/signup.html")
	public String signUpPage(Model model) {
		model.addAttribute("signUpUser", new SignUpUser());
		return "/public/signup";
	}

	@PostMapping("/checkSignUp")
	public String submitSignUp(@ModelAttribute("signUpUser") SignUpUser signUpUser, BindingResult bindingResult,
			Model model) {
		// Añade los valores de logueo a un objeto Cliente porque solo se registran clientes desde esa ventana.
		Client client = new Client(signUpUser.getDni(), signUpUser.getEmail(), signUpUser.getName(),
				signUpUser.getPassword(), signUpUser.getPhone(), LocalDateTime.now());
		
		// Mensajes que luego mostraré en la vista en caso de que se cumplan los errores.
		String existingUserEmailError = "Ya existe un usuario con ese email.";
		String existingUserDniError = "Ya existe un usuario con ese DNI.";

		// Comprobación de que ya existe un usuario con ese correo que se ha ingresado en el formulario de registro
		boolean existingUserEmail = clientService.findFirstByEmail(signUpUser.getEmail()) != null;
		// Comprobación de que ya existe un usuario con ese DNI que se ha ingresado en el formulario de registro
		boolean existingUserDni = clientService.findFirstByDni(signUpUser.getDni()) != null;

		// Si existe el email, añado al modelo el mensaje de error de email, si existe el dni, añado al modelo el mensaje de error de DNI, y si no se cumple ninguno de los dos, guardo el Cliente en la BD.
		if (existingUserEmail) {
			model.addAttribute("existingUser", existingUserEmailError);
		} else if (existingUserDni) {
			model.addAttribute("existingUser", existingUserDniError);
		} else {
			clientService.save(client);

			session.setAttribute("loggedUser", client);
		}
		return "redirect:/";
	}

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
			model.addAttribute("loginError", "El usuario o contraseña no es válido");
			return "/index";
		}
	}

	@GetMapping("/logOut")
	public String logOut(Model model) {
		session.setAttribute("loggedUser", null);
		return "redirect:/";
	}
}
