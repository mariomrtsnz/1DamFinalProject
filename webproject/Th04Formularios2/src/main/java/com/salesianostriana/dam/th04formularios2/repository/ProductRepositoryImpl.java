package com.salesianostriana.dam.th04formularios2.repository;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.th04formularios2.model.Product;

/*En el repository irán los métodos DAO para el acceso a los datos. En este ejemplo, como no tenemos todavía
 * base de datos, los DAO directamente devuelven la lista de productos con datos creada en el método init */

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	List <Product> list;

	@PostConstruct
	public void init() {
		
		
		
		list = new ArrayList<Product>();
		
		list.add(new Product(1,"Cruzcampo", "Caja de 24 botellines Cruzcampo", 9.6365, false, LocalDate.of(2019, Month.DECEMBER, 12), "1Cruz24.jpg"));
		list.add(new Product(2,"Cruzcampo", "Pack de 6 botellines Cruzcampo", 5.4, false,LocalDate.of(2018, Month.JANUARY, 10 ),"2Cruz6.jpg"));
		list.add(new Product(3,"Paulaner", "Botellín 60cl Paulaner", 2.4, true, LocalDate.of(2018, Month.NOVEMBER, 10 ), "3Paulaner1.jpg"));
		list.add(new Product(4,"Budweiser", "Caja de 6 botellines Budweiser", 6.3, true, LocalDate.of(2017, Month.JULY, 15 ), "4Budweiser6.jpg"));
		list.add(new Product(5,"Franciskaner", "Botellín 60cl Franciskaner", 1.3, true, LocalDate.of(2020, Month.JANUARY, 9 ), "5Franziskaner1.jpg"));
		list.add(new Product(6,"Alhambra", "Caja de 6 botellines Alhambra 1925", 5.5, false, LocalDate.of(2018, Month.JUNE, 10 ), "6Alambra6.jpg"));
		
		
	}
	
	public List<Product> findAll() {
		return list;
	}
	
	/*En el ejemplo, buscamos el producto en la lista por id y devolvemos el producto buscado o null
	 * si no se encuentra en la lista.
	 * Más adelante veremos qu eno es necesario crear estos métodos y que los buscar se hacen
	 * directamente sin tener que escribir el código de dentro*/
	public Product findById(long id) {
		if (id >= 0 && id <= list.size()) {
			return list.get((int) id-1);
		}
		else{
			return null;
		}
	}
	
}
