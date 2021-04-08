package br.com.cronos.brutus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cronos.brutus.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
