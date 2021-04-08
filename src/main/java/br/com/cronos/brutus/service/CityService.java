package br.com.cronos.brutus.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cronos.brutus.exception.ObjectNotFoundException;
import br.com.cronos.brutus.model.City;
import br.com.cronos.brutus.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;

	public Optional<City> findById(Long id) {

		Optional<City> city = this.repository.findById(id);

		if (city.orElse(null) == null) {

			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return city;
	}

	public void saveAll(City... cities) {
		this.repository.saveAll(Arrays.asList(cities));
	}

	public void saveAll(Collection<City> cities) {
		this.repository.saveAll(cities);
	}
}
