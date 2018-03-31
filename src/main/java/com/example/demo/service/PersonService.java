package com.example.demo.service;

import com.example.demo.dto.PersonDTO;

import java.util.List;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
public interface PersonService {

    List<PersonDTO> findAll(int limit, int offset);

    PersonDTO findOne(Long id);

    List<PersonDTO> findOrderBy(String column);

}
