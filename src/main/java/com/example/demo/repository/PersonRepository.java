package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
