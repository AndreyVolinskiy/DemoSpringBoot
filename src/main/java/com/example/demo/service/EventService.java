package com.example.demo.service;

import com.example.demo.model.Event;

import java.util.List;

/**
 * @author Andrey Volinskiy on 31.03.2018.
 */
public interface EventService {

    Event create(String name);

    Event findOneById(long id);

    List<Event> findAll(int limit, int offset);

    List<Event> findAllByName(String name, int limit, int offset);
}
