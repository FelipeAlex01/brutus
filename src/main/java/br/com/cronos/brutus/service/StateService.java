package br.com.cronos.brutus.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cronos.brutus.exception.ObjectNotFoundException;
import br.com.cronos.brutus.model.State;
import br.com.cronos.brutus.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;

	public Optional<State> findById(Long id) {

		Optional<State> state = this.repository.findById(id);

		if (state.orElse(null) == null) {

			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return state;
	}

	public void saveAll(State... states) {
		this.repository.saveAll(Arrays.asList(states));
	}

	public void saveAll(Collection<State> states) {
		this.repository.saveAll(states);
	}
}
