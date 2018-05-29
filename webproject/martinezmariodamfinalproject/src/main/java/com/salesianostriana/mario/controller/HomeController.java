package com.salesianostriana.mario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController implements ErrorController{

	@Autowired
	HttpSession session;
	
	@GetMapping({ "/index", "/index.html" })
	public String indexPage() {
		session.setAttribute("loggedUser", null);
		return "index";
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
