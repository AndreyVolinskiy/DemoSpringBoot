package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Andrey Volinskiy on 21.03.2018.
 */
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/{name}/{login}/{password}/{email}/{age}/{orgId}")
    public UserDTO create(@PathVariable("name") String name, @PathVariable("login") String login, @PathVariable("password") String password,
                          @PathVariable("email") String email, @PathVariable("age") int age, @PathVariable("orgId") long orgId) {
        return userService.save(new User(name, login, password, email, age, orgId));
    }

    @GetMapping("/findAll")
    public List<UserDTO> findAll(@RequestParam int limit, @RequestParam int offset) {
        return userService.findAll(limit, offset);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public UserDTO findById(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

    @GetMapping("/findByEmail/{email}")
    public List<UserDTO> findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/findByAgeBetween/{from}/{to}")
    public List<UserDTO> findUsersByAgeBetween(@PathVariable("from") int from, @PathVariable("to") int to) {
        System.out.println(from);
        System.out.println(to);
        return userService.findUserInAgeBetween(from, to);
    }

    /**
     * @param id update existing user by id
     */
    @GetMapping("/update/{name}/{login}/{password}/{email}/{age}/{id}")
    public void update(@PathVariable("name") String name, @PathVariable("login") String login, @PathVariable("password") String password,
                       @PathVariable("email") String email, @PathVariable("age") int age, @PathVariable("id") int id) {
        List<UserDTO> userList = userService.findAll(100, 0);
        for (UserDTO elem : userList) {
            if (elem.getId() == id) {
                elem.setName(name);
                elem.setLogin(login);
                elem.setEmail(email);
                elem.setAge(age);
                elem.setDate(LocalDate.now().toString());
            }
        }
    }

    /**
     * @return list of all users founded by "name" parameter
     */
    @GetMapping("/findAllByName/{name}")
    public List<UserDTO> findAllByName(@PathVariable("name") String name) {
        return userService.findAllByName(name);
    }

    /**
     * @return list of all users founded by "login" parameter
     */
    @GetMapping("/findAllByLogin/{login}")
    public List<UserDTO> findAllByLogin(@PathVariable("login") String login) {
        return userService.findAllByLogin(login);
    }
}

