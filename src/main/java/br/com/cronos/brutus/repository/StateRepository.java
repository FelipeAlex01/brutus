package br.com.cronos.brutus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cronos.brutus.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
