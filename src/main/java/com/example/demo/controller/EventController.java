package com.example.demo.controller;

import com.example.demo.model.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

// TODO: 21.03.2018 findAllById
// TODO: 21.03.2018 findAllByName
// TODO: 21.03.2018  check index if not exist
/**
 * @author Andrey Volinskiy on 21.03.2018.
 */
@RequestMapping("/api/events")
@RestController
public class EventController {

    private List<Event> list = new LinkedList<>();

    /**
     * @return String "Simple event!!!"
     */
    @GetMapping("/simple")
    public String getSimpleEvent() {
        return "Simple event!!!";
    }

    /**
     * @param index
     * @return list element by index
     */
    @GetMapping("/findOne/{index}")
    public Event findOne(@PathVariable("index") int index) {
        Event event = new Event(0L, "Event doesn't exist, Index is out of range");
        int listSize = list.size();
        if (index < listSize) {
            event = list.get(index);
        }
        return event;
    }

    /**
     * @return list of all events
     */
    @GetMapping("/findAll")
    public List<Event> findAll() {
        return list;
    }

    /**
     * @param id
     * @return list of events by parameter id
     */
    @GetMapping("/findAllById/{id}")
    public List<Event> findAllById(@PathVariable("id") int id) {
        List<Event> resultList = new LinkedList<>();
        Event event = new Event(0L, "Event doesn't exist.");
        for (Event elem : list) {
            if (elem.getId() == id) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(event);
        }
        return resultList;
    }

    /**
     * @param name
     * @return list of events founded by parameter "name"
     */
    @GetMapping("/findAllByName/{name}")
    public List<Event> findAllByName(@PathVariable("name") String name) {
        List<Event> resultList = new LinkedList<>();
        Event event = new Event(0L, "Event doesn't exist.");
        for (Event elem : list) {
            if (elem.getName().equals(name)) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(event);
        }
        return resultList;
    }

    /**
     * @param id
     * @param name
     * @return created event with parameters name and id
     */
    @GetMapping("/create/{id}/{name}")
    public Event create(@PathVariable("id") Long id, @PathVariable("name") String name) {
        Event event = new Event(id, name);
        list.add(event);
        return event;
    }
}
