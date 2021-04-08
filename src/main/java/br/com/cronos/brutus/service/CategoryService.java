package br.com.cronos.brutus.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cronos.brutus.exception.ObjectNotFoundException;
import br.com.cronos.brutus.model.Category;
import br.com.cronos.brutus.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Optional<Category> findById(Long id) {

		Optional<Category> category = this.repository.findById(id);

		if (category.orElse(null) == null) {

			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return category;
	}

	public void saveAll(Category... categories) {
		this.repository.saveAll(Arrays.asList(categories));
	}

	public void saveAll(Collection<Category> categories) {
		this.repository.saveAll(categories);
	}
}
