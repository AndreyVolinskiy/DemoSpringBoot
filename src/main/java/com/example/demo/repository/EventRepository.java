package com.example.demo.repository;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Andrey Volinskiy on 27.03.2018.
 */
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByName(String name);
}
