package com.salesianostriana.b2b.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.b2b.model.Producto;
import com.salesianostriana.b2b.service.DistribuidorService;
import com.salesianostriana.b2b.service.ProductoService;

@RequestMapping("/distribuidor")
@Controller
public class DistribuidorController {
	
	@Autowired
	DistribuidorService distribuidorService;
	
	@Autowired
	ProductoService productoService;

	//Principal Distribuidor
	@GetMapping ({"/" , "distribuidor/" , "/distribuidor"})
	public String pcDis() {
		return "distribuidor/pc_dis";
	}
	
	//Forms Distribuidor
	@GetMapping ("/form_prod")
	public String pcAdmin7 (Model model) {
		model.addAttribute("productoForm", new Producto() );
		return "distribuidor/form_prod";
	}
	
	
	@GetMapping ("/form_dis")
	public String pcDis3 () {
		return "distribuidor/form_dis";
	}	
	
	//
	
	@GetMapping ("/g_prod")
	public String pcDis2 (Model model) {
		Iterable <Producto> listaProducto = new HashSet <Producto> ();
		listaProducto = productoService.findAll();
		model.addAttribute("panelAdmin", false);
		model.addAttribute("listaProducto", listaProducto );
		return "distribuidor/g_prod";
	}
	
	@PostMapping ("/addProducto")
	public String submitB(@ModelAttribute("productoForm") Producto producto,  Model model, @ModelAttribute("listaProducto") HashSet<Producto> listaProducto) {
		
		productoService.save(producto);
		listaProducto.add(producto);
		
		
		return "redirect:g_prod";
	}
	
	
	
}