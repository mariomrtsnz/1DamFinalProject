package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController implements ErrorController {

	@Autowired
	HttpSession session;
	
	@GetMapping({ "/", "/index", "/index.html" })
	public String indexPage(Model model) {
		return "index";
	}
	
	@GetMapping("/logOut")
	public String logOut(Model model) {
		session.setAttribute("loggedUser", null);
		return "redirect:/";
	}
	
	@RequestMapping("/error")
    public String handleError() {
        if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		} else {
			return "redirect:/public";
		}
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
