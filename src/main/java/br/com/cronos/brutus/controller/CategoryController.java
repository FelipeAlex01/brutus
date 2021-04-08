package br.com.cronos.brutus.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronos.brutus.model.Category;
import br.com.cronos.brutus.service.CategoryService;

@RestController
@RequestMapping("/categoria")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Category> category = this.service.findById(id);
		return ResponseEntity.ok().body(category);
	}

}
