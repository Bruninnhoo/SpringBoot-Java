package br.com.brunodev.rest_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.brunodev.rest_api.PersonServices;
import br.com.brunodev.rest_api.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Person findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

}
