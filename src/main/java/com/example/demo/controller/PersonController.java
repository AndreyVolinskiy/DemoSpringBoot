package com.example.demo.controller;

import com.example.demo.dto.PersonDTO;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/findAll")
    public List<PersonDTO> findAll(@RequestParam int limit, @RequestParam int offset) {
        return personService.findAll(limit, offset);
    }

    @GetMapping("/findOne/{id}")
    public PersonDTO findOne(@PathVariable("id") Long id) {
        return personService.findOne(id);
    }

    @GetMapping("/findOrderBy/{column}")
    public List<PersonDTO> findOrderBy(@PathVariable("column") String column) {
        return personService.findOrderBy(column);


    }
}
