package br.com.brunodev.rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brunodev.rest_api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
