package br.com.brunodev.rest_api.services;

import java.util.logging.Logger;
import br.com.brunodev.rest_api.model.Person;
import br.com.brunodev.rest_api.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all persons");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person");
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public Person createPerson(Person person) {
        logger.info("Creating one Person");
        return repository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating one Person");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("Person not found"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void deletePerson(Long id) {
        logger.info("Deleting one Person");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        repository.delete(entity);
    }
}
