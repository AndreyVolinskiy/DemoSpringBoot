package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andrey Volinskiy on 21.03.2018.
 */
@RequestMapping("/api/event")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * @return element by id
     */
    @GetMapping("/findOne/{id}")
    public Event findOneById(@PathVariable("id") long id) {
        return eventService.findOneById(id);
    }

    /**
     * @return list of all events
     */
    @GetMapping("/findAll")
    public List<Event> findAll(@RequestParam int limit, @RequestParam int offset) {
        return eventService.findAll(limit, offset);
    }

     /**
     * @return list of events founded by parameter "name"
     */
    @GetMapping("/findAllByName/{name}")
    public List<Event> findAllByName(@PathVariable("name") String name, @RequestParam int limit, @RequestParam int offset) {
        return eventService.findAllByName(name, limit, offset);
    }

    /**
     * @return created event with parameter name
     */
    @GetMapping("/create/{name}")
    public Event create(@PathVariable("name") String name) {
        return eventService.create(name);
    }
}
