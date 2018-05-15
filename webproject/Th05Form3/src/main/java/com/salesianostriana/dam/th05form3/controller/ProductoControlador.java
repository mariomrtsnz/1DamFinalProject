package com.salesianostriana.dam.th05form3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.th05form3.model.Producto;

@Controller
public class ProductoControlador {

	@GetMapping("/producto")
	public String showFormProducto(Model model) {

		Producto producto = new Producto();
		model.addAttribute("productoForm", producto);

		//Creamos un array de String para los tipos de cerveza. Nos servirá para trabajar con radiobuttons en la vista y recoger 
		//lo que el usuario pincha
		
		String[] tipos = new String[] { "Lager", "Pilsen", "Guiness" };

		model.addAttribute("tipos", tipos);

		// Trabajo con las fechas, con el binder
		
		//Calendar cal = Calendar.getInstance();

		return "FormProducto";
	}

	/*Usamos el parámetro BindingResult que será quien tengan la información de si se ha producido algún error en el formulario.
	 * En este caso, solo hemos tenido en cuenta la validación del formato de la fecha, aunque puede haber muchas más, por ejemplo, 
	 * rangos, formato de números, etc. Se puede ver más en tutorial colgado en la plataforma*/
	
	@PostMapping("/addProducto")
	public String submit(@ModelAttribute("productoForm") Producto producto, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "FormProducto";
		} else {
			model.addAttribute("producto", producto);
			return "View";			
		}
		
	}
	

	 
}
