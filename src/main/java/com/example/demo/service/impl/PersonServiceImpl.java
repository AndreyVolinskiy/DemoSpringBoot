package com.example.demo.service.impl;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<PersonDTO> findAll(int limit, int offset) {
        Page<Person> list = personRepository.findAll(new PageRequest(offset, limit));
        List<PersonDTO> personDTOList = new LinkedList<>();
        list.map(s -> personDTOList.add(mappingToPersonDto(s)));
        return personDTOList;
    }

    @Override
    public List<PersonDTO> findOrderBy(String column) {
        List<Person> personList = personRepository.findAll(new Sort(Sort.Direction.ASC, column));
        List<PersonDTO> personDTOList = new LinkedList<>();
        for (Person person : personList) {
            personDTOList.add(mappingToPersonDto(person));
        }
        return personDTOList;
        // TODO: 28.03.2018 return dto - DONE
    }

    @Override
    public PersonDTO findOne(Long id) {
        Person person = personRepository.findById(id).get();
        return mappingToPersonDto(person);
    }

    private PersonDTO mappingToPersonDto(Person person) {
        val personDTO = new PersonDTO();
        personDTO.setEmail(person.getEmail());
        personDTO.setName(person.getName());
        personDTO.setId(person.getId());
        String orgName = organizationRepository.findById(person.getOrganizationId()).get().getName();
        personDTO.setOrganization(orgName);
        return personDTO;
    }
}
