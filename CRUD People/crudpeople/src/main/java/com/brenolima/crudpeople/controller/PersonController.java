package com.brenolima.crudpeople.controller;

import com.brenolima.crudpeople.model.Person;
import com.brenolima.crudpeople.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping
    public List<Person> list() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        repository.deleteById(id);
        return true;
    }

    @PutMapping("/update/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        return repository.findById(id)
        .map(existingPerson -> {
            existingPerson.setName(person.getName());
            existingPerson.setAge(person.getAge());
            return repository.save(existingPerson);
        })
        .orElseThrow(() -> new RuntimeException("Person not found"));
    }
}
