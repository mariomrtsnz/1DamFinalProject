package com.salesianostriana.b2b.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.b2b.model.Categoria;
import com.salesianostriana.b2b.model.Distribuidor;
import com.salesianostriana.b2b.model.Empresa;
import com.salesianostriana.b2b.model.Producto;
import com.salesianostriana.b2b.service.CategoriaService;
import com.salesianostriana.b2b.service.DistribuidorService;
import com.salesianostriana.b2b.service.EmpresaService;
import com.salesianostriana.b2b.service.ProductoService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductoService productoService;

	@Autowired
	EmpresaService empresaService;

	@Autowired
	DistribuidorService distribuidorService;

	@Autowired
	CategoriaService categoriaService;

	// Pagina Principal

	@GetMapping({"/","/index"})
	public String pcAdmin() {
		return "admin/pc_admin";
	}

	// Rutas Formularios
	@GetMapping("/form_prod")
	public String pcAdmin7(Model model) {
		model.addAttribute("productoForm", new Producto());
		return "admin/form_prod";
	}

	@GetMapping("/form_emp")
	public String pcAdmin8(Model model) {
		model.addAttribute("empresaForm", new Empresa());
		return "admin/form_emp";
	}

	@GetMapping("/form_cat")
	public String pcAdmin9(Model model) {
		model.addAttribute("categoriaForm", new Categoria());
		return "admin/form_cat";
	}

	@GetMapping("/form_dis")
	public String pcAdmin10(Model model) {
		model.addAttribute("distribuidorForm", new Distribuidor());
		return "admin/form_dis";
	}

	// Formulario Add Distribuidores (Admin)

	@GetMapping("/g_dis")
	public String pcDis4(Model model) {
		Iterable<Distribuidor> listaDistribuidor = new HashSet<Distribuidor>();
		listaDistribuidor = distribuidorService.findAll();
		model.addAttribute("listaDistribuidor", listaDistribuidor);
		return "admin/g_dis";
	}

	@PostMapping("/addDistribuidor")
	public String submit(@ModelAttribute("distribuidorForm") Distribuidor distribuidor, Model model,
			@ModelAttribute("listaDistribuidor") HashSet<Distribuidor> listaDistribuidor) {

		distribuidorService.save(distribuidor);
		listaDistribuidor.add(distribuidor);

		return "redirect:g_dis";
	}
	// Formulario Add Empresa (Admin)

	@GetMapping("/g_user")
	public String pcDis5(Model model) {
		Iterable<Empresa> listaEmpresa = new HashSet<Empresa>();
		listaEmpresa = empresaService.findAll();
		model.addAttribute("listaEmpresa", listaEmpresa);
		return "admin/g_user";
	}

	@PostMapping("/addEmpresa")
	public String submit(@ModelAttribute("empresaForm") Empresa empresa, Model model,
			@ModelAttribute("listaEmpresa") HashSet<Empresa> listaEmpresa) {

		empresaService.save(empresa);
		listaEmpresa.add(empresa);

		return "redirect:g_user";
	}

	// Formlario Add Producto (Admin)

	@GetMapping("/g_prod")
	public String pcAdmin4(Model model) {
		Iterable<Producto> listaProducto = new HashSet<Producto>();
		listaProducto = productoService.findAll();
		model.addAttribute("panelAdmin", true);
		model.addAttribute("listaProducto", listaProducto);
		return "admin/g_prod";
	}

	@PostMapping("/addProducto")
	public String submit(@ModelAttribute("productoForm") Producto producto, Model model,
			@ModelAttribute("listaProducto") HashSet<Producto> listaProducto) {

		productoService.save(producto);
		listaProducto.add(producto);

		return "redirect:g_prod";
	}
	
	// Formulario Add Categoria

	@GetMapping("/g_cat")
	public String pcAdmin6(Model model) {
		Iterable<Categoria> listaCategoria = new HashSet<Categoria>();
		listaCategoria = categoriaService.findAll();
		model.addAttribute("listaCategoria", listaCategoria);
		return "admin/g_cat";
	}

	@PostMapping("/addCategoria")
	public String submit(@ModelAttribute("categoriaForm") Categoria categoria, Model model,
			@ModelAttribute("listaCategoria") HashSet<Categoria> listaCategoria) {

		categoriaService.save(categoria);
		listaCategoria.add(categoria);

		return "redirect:g_cat";
	}
	
	//
	
	@GetMapping("/g_prod/{id}")
    public String editProd(@PathVariable("id") Long id, Model model) {
        Producto p = productoService.findOne(id);

        if (p == null) {
            return "redirect:g:prod";
        } else {
            model.addAttribute("producto", p);
            return "admin/g_prod";
        }
    }

    @PostMapping("/editProducto")
    public String doEditProd(@ModelAttribute Producto producto) {
        productoService.edit(producto);
        return "redirect:g_prod";
    }

    @GetMapping("/delete-client/{id}")
    public String deleteProducto(@PathVariable("id") Long id, Model model) {
        Producto p = productoService.findOne(id);
        productoService.delete(p);
        return "redirect:g_prod";
    }

}
