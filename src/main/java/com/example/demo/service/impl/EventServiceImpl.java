package com.example.demo.service.impl;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey Volinskiy on 31.03.2018.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event create(String name) {
        return eventRepository.save(new Event(name));
    }

    @Override
    public Event findOneById(long id) {
        List<Event> list = eventRepository.findAll();
        for (Event event : list) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    @Override
    public List<Event> findAll(int limit, int offset) {
        Page<Event> list = eventRepository.findAll(new PageRequest(offset, limit));
        List<Event> resultList = new LinkedList<>();
        list.forEach(s-> resultList.add(s));
        return resultList;
    }

    @Override
    public List<Event> findAllByName(String name, int limit, int offset) {
        Assert.notNull(name, "name can`t be null!");
        Page<Event> list = eventRepository.findAll(new PageRequest(offset, limit));
        List<Event> resultList = new LinkedList<>();
        for (Event event : list) {
            if (event.getName().equals(name)) {
                resultList.add(event);
            }
        }
        return resultList;
    }
}
