package br.com.cronos.brutus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "categoria")

public class Category extends AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@JsonManagedReference
	@ManyToMany(mappedBy = "categories")
	private List<Product> products = new ArrayList<>();

	@Override
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	@Override
	public String toString() {
		return "Category [id=" + this.id + ", name=" + this.name + "]";
	}

}
