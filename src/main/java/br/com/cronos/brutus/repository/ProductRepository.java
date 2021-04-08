package br.com.cronos.brutus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cronos.brutus.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
