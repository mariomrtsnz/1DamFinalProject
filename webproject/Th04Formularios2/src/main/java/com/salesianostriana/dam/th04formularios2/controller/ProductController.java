package com.salesianostriana.dam.th04formularios2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.th04formularios2.model.Product;
import com.salesianostriana.dam.th04formularios2.service.ProductService;

//Clase controller para los productos

@Controller
public class ProductController {
	
	/*Necesitamos un objeto de ProducService ya que en esta clase, vamos a atender peticiones
	 * que piden buscar objetos, y son los servicions los que se dedican a buscar
	 * @Autowired, no spermite inyectar las dependencias que se necesiten. En este caso, al ser el 
	 * atributo el etiquetado con el @Autowired, se crea el objeto y luego se le inyecta la dependiencia*/
	
	@Autowired
	private ProductService productService;
	
	/*Al pinchar en productos queremos que se nos muestre un listado de ellos, por lo que
	 * añadimos al modelo la variable de nombre "prods" que tendrá como valor el valor devuelto
	 * por el método obtenerProductos (). Este método, está en la interfaz ProdcutService
	 * e implementado en ProductServiceImpl puesto que el paquete service es quien realiza
	 * la lógica de negocio (en este caso, busca los productos y devuelve una lista de productos tipo List).
	 * El Service es quien accederá a uno (en general a varios) Repository y este último a su vez, accede al
	 * modelo o base de datos con los métodos DAO*/
	
	@GetMapping("/productos") 
	public String catalogoProductos(Model model) {
		
		model.addAttribute("prods", productService.obtenerProductos());
		
		return "Productos";
	}
	
	/*Método que atiende a la petición de ver un producto concreto pinchando en el 
	 * botón ver producto de cada uno, se debe recoger el id de ese producto, por lo que
	 * en el gGetMapping, después de /producto/vamos al id. Eso se indica y recoge pasando
	 * como parámetro al método el @PathVariable ("id") y un long id*/
	
	@GetMapping("/producto/{id}")
	public String detalleProducto(@PathVariable("id") long id, Model model){
		
		Product p = productService.obtenerUnProducto(id);
		
		if (p != null) {
			model.addAttribute("producto",p);
			return "DetalleProducto";
		} else {
			//tratamiento del error
			return "Error";
		
		}
	}
	@GetMapping ("/FormProductos")
	public String showForm(Model model) {
		
		Product empleado = new Product();
		model.addAttribute("FormProduct", empleado);
		
		return "FormProductos";
		
	}

	@PostMapping ("/addProducto")
	public String submit(@ModelAttribute("FormProduct") Product product,  Model model) {
		
		model.addAttribute("producto", product);
		return "productos";
	}
	
}
