package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Andrey Volinskiy on 21.03.2018.
 */
@RequestMapping("/api/events")
@RestController
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    /**
     * @return element by id
     */
    @GetMapping("/findOne/{index}")
    public Event findOneById(@PathVariable("index") long id) {
        return eventRepository.findById(id).get();
    }

    /**
     * @return list of all events
     */
    @GetMapping("/findAll")
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

     /**
     * @return list of events founded by parameter "name"
     */
    @GetMapping("/findAllByName/{name}")
    public List<Event> findAllByName(@PathVariable("name") String name) {
        return eventRepository.findAllByName(name);
    }

    /**
     * @return created event with parameter name
     */
    @GetMapping("/create/{name}")
    public Event create(@PathVariable("name") String name) {
        return eventRepository.save(new Event(name));
    }
}
