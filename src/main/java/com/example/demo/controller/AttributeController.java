package com.example.demo.controller;

import com.example.demo.model.Attribute;
import com.example.demo.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andrey Volinskiy on 23.03.2018.
 */
@RestController
@RequestMapping("/api/attribute")
public class AttributeController {

    // get get
    // post save
    // put modify
    // delete delete

    @Autowired
    private AttributeRepository attributeRepository;

    @PostMapping("/save/{name}/{level}")
    public Attribute create(@PathVariable("name") String name, @PathVariable("level") int level) {
        return attributeRepository.save(new Attribute(name, level));
    }

    @GetMapping("/findAll")
    public List<Attribute> findAll() {
        return attributeRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        attributeRepository.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Attribute findById(@PathVariable("id") Long id) {
        return attributeRepository.findById(id).get();
    }
}
