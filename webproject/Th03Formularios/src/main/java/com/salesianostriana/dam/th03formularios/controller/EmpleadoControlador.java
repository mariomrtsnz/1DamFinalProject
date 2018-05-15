package com.salesianostriana.dam.th03formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.salesianostriana.dam.th03formularios.model.Empleado;

//Esta clase ya se va a encargar de atender peticiones de dos tipos, get y post

@Controller
public class EmpleadoControlador {

	/*Vamos a tener dos controladores, uno para VER (petición tipo Get) los datos del formulario y otro para
	 * GESTIONAR (Petición tipo Post) los datos del formulario*/
	
	
	/*Este primer método solo muestra el formulario y es igual a los que ya hemos usado en 
	 * otras ocasiones
	 * un Model al que añadimos una instancia de nuestra clase modelo tipo Empleado
	 * sin ningún valor por eso está vacío, petición tipo Get*/
	
	//@RequestMapping(value = "/empleado", method = RequestMethod.GET), forma más antigua
	@GetMapping ("/empleado")
	public String showForm(Model model) {
		
		Empleado empleado = new Empleado();
		model.addAttribute("empleadoForm", empleado);
		
		return "form";
		
	}

	/*Para la petición tipo Post. Este método gestionará los datos que se introduzcan en el formulario recogiendo
	 * los datos de los diferentes campos.
	 * Para ello añadimos la anotación @ModelAttribute como parámetro del método para decirle de qué formulario 
	 * debe coger los datos y "crear" un Empleado, de ahí el Empleado empleado
	 * Se le pasa tamnbién el model como siempre*/
	
	//@RequestMapping(value = "/addEmpleado", method = RequestMethod.POST), sería usando la antigua forma Request...
	@PostMapping ("/addEmPleado")
	public String submit(@ModelAttribute("empleadoForm") Empleado empleado,  Model model) {
		//System.out.println(empleado);
		//Se añade al modelo, el empleado que se creará al recoger los datos del formulario
		model.addAttribute("empleado", empleado);
		//Se muestra la página con la información mandada en el formulario al pulsar el botón submit
		return "view";
	}
	
}
