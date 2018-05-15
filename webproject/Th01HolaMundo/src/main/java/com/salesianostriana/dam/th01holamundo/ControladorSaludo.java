package com.salesianostriana.dam.th01holamundo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*Necesitamos una clase que separa la vista del modelo, en este caso, un controller que se encarga
 * de atender las peticiones. Los controller:
 * Atienden las peticiones
 * Procesan los datos que llegan de las peticiones
 * Hacen peticiones a la BBDD
 * Definien la información que se verá en la web (modelo)
 * Determinan qué vista será la encargada de generar la pg HTML
 * 
*/

@Controller
public class ControladorSaludo {
	
	//"/saludo" es la página que queremos mostrar, el recurso a mostrar y escribir en el navegador después de
	//Localhost:8090
	//@RequestMapping indica que el método justo debajo será el que atenderá la petición tipo Get 
	//(cuando solo hay una se supone tipo get, cuando sea Post (formulario) tendremos dos métodos "/saludo"
	@RequestMapping("/saludo") 
	public String greeting(Model model) {
		//El parámetro "nombre" es la palabra que usamos en la plantilla dentro
		// de <p>Hello <span th:text="${nombre}">Friend</span>!</p>
		model.addAttribute("nombre", "World");//Incluimos la información en el modelo
		return "PlantillaSaludo";//Nombre de la plantilla que generará la página HTML, en nuestro caso
		//dentro de templates, PlantillaSaludo.html
	}
	
	//Segundo ejemplo, donde se pueden ver distintos parámetros que se le pasan al model, como un objeto de la clase
	//Persona, con valores de sus dos atributos
	
	@RequestMapping("/saludo2")
	public String otroSaludo(Model model) {
		model.addAttribute("persona",new Persona("Ángel", "Naranjo González"));
		return "PlantillaOtroSaludo";//Devolveos a otra plantilla diferente
	}
	
	/*@GetMapping es una variante de requestMapping, más "nueva" que se utiliza como atajo, ya que 
	 * basta con el nombre del recurso, mientras que con @RequestMapping, en general tenemos que ir 
	 * diciendo el tipo de petición que se está atendiendo, es decir, 
	 * necesita que le indiquemos el value (nombre el recurso) y el método que se usa para
	 * la petición, en nuestro caso RequestMethod.Get (también existe RequestMethod.POST)
	 * En general, se usa por simplificar el código 
	 * Se puede ver un ejemplo en: https://www.arquitecturajava.com/spring-getmapping-postmapping-etc/*/
	
	@GetMapping("/saludo3") 
	//@RequestMapping (value="/saludo3", method=RequestMethod.GET)
	public String saludoController3 (Model model){
		
        model.addAttribute("saludo", "Hola Mundo!!!");
        model.addAttribute("mensaje","Me llena de orgullo y satisfacción...");
        model.addAttribute("url", "https://triana.salesianos.edu");
        return "PlantillaSaludo3";

        /*Para ver la relación entre unos valores y otros, podemos ver en la plantilla html saludo3:
         * 
         * 	<div class="jumbotron">
		<div class="container">
			<h1 th:text="${saludo}"> </h1>
			<p th:text="${mensaje}"></p>
			<p>
				<a class="btn btn-primary btn-lg" target="_blank" th:href="${url}"
					role="button">Learn more &raquo;</a>
			</p>
		</div>*/
        
        
	}
	

	/* Como es el primer ejemplo, usaremos este mismo método para crear dentro una lista de 
	 * personas, del tipo List y guardaremos directamente varias personas de ejemplo
	 * Posteriormente, basta con añadir la lista al model con un nombre (los elementos de la lista vendrán, 
	 * por ejemplo, de la búsqueda en una base de datos) y devolver como siempre
	 * el string con la plantilla html donde lo queremos mostrar*/
	
	@GetMapping("/list")
	public String listarVarios (Model model) {
		
		List<Persona> lista = new ArrayList<Persona>();
		
		lista.add(new Persona("Ángel", "Naranjo González"));
		lista.add(new Persona ("Perry", "Mason"));
		lista.add(new Persona ("perro", "Doraemon"));
		
		model.addAttribute("listado", lista);
		
		return "PlantillaListar";
	}
}
