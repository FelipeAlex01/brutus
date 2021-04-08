package br.com.cronos.brutus.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "produto")
public class Product extends AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "preco", length = AbstractModel.UNIT_VALUE_FRACTION, scale = AbstractModel.DOUBLE_UNIT_VALUE_FRACTION)
	private BigDecimal price;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "produto_categorias", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Category> categories = new ArrayList<>();

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

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	@Override
	public String toString() {
		return "Produto [id=" + this.id + ", name=" + this.name + ", price=" + this.price + "]";
	}

}
