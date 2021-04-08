package br.com.cronos.brutus;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.cronos.brutus.model.Category;
import br.com.cronos.brutus.model.Product;
import br.com.cronos.brutus.service.CategoryService;
import br.com.cronos.brutus.service.ProductService;

@Component
public class ServletInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

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

		this.categoryService.saveAll(category1, category2);
		this.productService.saveAll(product1, product2);

	}
}
