package br.com.cronos.brutus.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

//@Entity(name = "cliente")
public class Client extends AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "email")
	private String email;

	//@ManyToMany
	//@JoinTable(name = "cliente_telefones", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "phone", referencedColumnName = "id"))
	@Transient
	private Set<Phone> phones;

	@Transient
	private Collection<Phone> phonesEncapsulator;

	@Override
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Phone> getPhonesEncapsulator() {

		if (this.phones == null) {
			this.phones = new LinkedHashSet<>();
		}

		if (this.phonesEncapsulator == null) {
			this.phonesEncapsulator = new ArrayList<Phone>(this.phones);
		}

		return this.phonesEncapsulator;
	}

}
