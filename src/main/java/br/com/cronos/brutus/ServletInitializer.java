package br.com.cronos.brutus;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.cronos.brutus.model.Category;
import br.com.cronos.brutus.model.City;
import br.com.cronos.brutus.model.Product;
import br.com.cronos.brutus.model.State;
import br.com.cronos.brutus.service.CategoryService;
import br.com.cronos.brutus.service.CityService;
import br.com.cronos.brutus.service.ProductService;
import br.com.cronos.brutus.service.StateService;

@Component
public class ServletInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService CityService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Category category1 = new Category();
		category1.setName("Escritório");

		Category category2 = new Category();
		category2.setName("Informática");

		Product product1 = new Product();
		product1.setName("Notebook");
		product1.setPrice(new BigDecimal(4500));

		Product product2 = new Product();
		product2.setName("Caneta");
		product2.setPrice(new BigDecimal(2));

		product1.getCategories().addAll(Arrays.asList(category1, category2));
		product2.getCategories().add(category1);

		State state1 = new State();
		state1.setName("Pernambuco");

		State state2 = new State();
		state2.setName("São Paulo");

		City city1 = new City();
		city1.setName("Olinda");
		city1.setState(state1);

		City city2 = new City();
		city2.setName("Recife");
		city2.setState(state1);

		City city3 = new City();
		city3.setName("Campinas");
		city3.setState(state2);

		this.categoryService.saveAll(category1, category2);
		this.productService.saveAll(product1, product2);
		
		this.stateService.saveAll(state1, state2);
		this.CityService.saveAll(Arrays.asList(city1, city2, city3));

	}
}
