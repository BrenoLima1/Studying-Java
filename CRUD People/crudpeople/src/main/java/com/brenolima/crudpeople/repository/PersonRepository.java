package com.brenolima.crudpeople.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brenolima.crudpeople.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
