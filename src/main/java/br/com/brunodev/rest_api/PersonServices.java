package br.com.brunodev.rest_api;

import java.util.logging.Logger;
import br.com.brunodev.rest_api.model.Person;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all persons");
        return List.of(new Person(1L, "Bruno", "Dev", "Rua Tal", "Masculino"),
                new Person(2L, "Maria", "Silva", "Rua Tal", "Feminino"));
    }

    public Person findById(Long id) {
        logger.info("Finding one person");
        return new Person(1L, "Bruno", "Dev", "Rua Tal", "Masculino");
    }

    public Person createPerson(Person person) {
        logger.info("Creating one Person");
        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("Updating one Person");
        return person;
    }

    public void deletePerson(Long id) {
        logger.info("Deleting one Person");
    }
}
