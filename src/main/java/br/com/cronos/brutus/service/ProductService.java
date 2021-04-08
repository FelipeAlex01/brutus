package br.com.cronos.brutus.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cronos.brutus.model.Product;
import br.com.cronos.brutus.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public void saveAll(Product... products) {
		this.repository.saveAll(Arrays.asList(products));
	}

	public void saveAll(Collection<Product> products) {
		this.repository.saveAll(products);
	}

}
