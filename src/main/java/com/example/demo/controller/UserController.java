package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


// TODO: 21.03.2018 create new UserController
// TODO: 21.03.2018 new model User (.....)
// TODO: 21.03.2018 findAllBy....
// TODO: 21.03.2018 create, update, delete, findAll

/**
 * @author Andrey Volinskiy on 21.03.2018.
 */
@RequestMapping("/api/users")
@RestController
public class UserController {

    private List<User> userList = new LinkedList<>();

    /**
     * @param id delete existing users with parameter "id"
     */
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        Iterator<User> iterator = userList.iterator();
        User user;
        while (iterator.hasNext()) {
            user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    /**
     * @param name
     * @param login
     * @param password
     * @param email
     * @param age
     * @param id       update existing user by id
     */
    @GetMapping("/update/{name}/{login}/{password}/{email}/{age}/{id}")
    public void update(@PathVariable("name") String name, @PathVariable("login") String login, @PathVariable("password") String password,
                       @PathVariable("email") String email, @PathVariable("age") int age, @PathVariable("id") int id) {
        for (User elem : userList) {
            if (elem.getId() == id) {
                elem.setName(name);
                elem.setLogin(login);
                elem.setPassword(password);
                elem.setEmail(email);
                elem.setAge(age);
            }
        }
    }

    /**
     * @param name
     * @param login
     * @param password
     * @param email
     * @param age
     * @param id
     * @returns created user, add it to userList
     */
    @GetMapping("/create/{name}/{login}/{password}/{email}/{age}/{id}")
    public User create(@PathVariable("name") String name, @PathVariable("login") String login, @PathVariable("password") String password,
                       @PathVariable("email") String email, @PathVariable("age") int age, @PathVariable("id") int id) {
        User user = new User(name, login, password, email, age, id);
        userList.add(user);
        return user;
    }

    /**
     * @return all users
     */
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userList;
    }

    /**
     * @param name
     * @return list of all users founded by "name" parameter
     */
    @GetMapping("/findAllByName/{name}")
    public List<User> findAllByName(@PathVariable("name") String name) {
        List<User> resultList = new LinkedList<>();
        User noUser = new User("No user founded", "", "", "", 0, 0);
        for (User elem : userList) {
            if (elem.getName().equals(name)) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(noUser);
        }
        return resultList;
    }

    /**
     * @param login
     * @return list of all users founded by "login" parameter
     */
    @GetMapping("/findAllByLogin/{login}")
    public List<User> findAllByLogin(@PathVariable("login") String login) {
        List<User> resultList = new LinkedList<>();
        User noUser = new User("No user founded", "", "", "", 0, 0);
        for (User elem : userList) {
            if (elem.getLogin().equals(login)) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(noUser);
        }
        return resultList;
    }

    /**
     * @param password
     * @return list of all users founded by "password" parameter
     */
    @GetMapping("/findAllByPassword/{password}")
    public List<User> findAllByPassword(@PathVariable("password") String password) {
        List<User> resultList = new LinkedList<>();
        User noUser = new User("No user founded", "", "", "", 0, 0);
        for (User elem : userList) {
            if (elem.getPassword().equals(password)) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(noUser);
        }
        return resultList;
    }

    /**
     * @param email
     * @return list of all users founded by "email" parameter
     */
    @GetMapping("/findAllByEmail/{email}")
    public List<User> findAllByEmail(@PathVariable("email") String email) {
        List<User> resultList = new LinkedList<>();
        User noUser = new User("No user founded", "", "", "", 0, 0);
        for (User elem : userList) {
            if (elem.getEmail().equals(email)) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(noUser);
        }
        return resultList;
    }

    /**
     * @param age
     * @return list of all users founded by "age" parameter
     */
    @GetMapping("/findAllByAge/{age}")
    public List<User> findAllByAge(@PathVariable("age") int age) {
        List<User> resultList = new LinkedList<>();
        User noUser = new User("No user founded", "", "", "", 0, 0);
        for (User elem : userList) {
            if (elem.getAge() == age) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(noUser);
        }
        return resultList;
    }

    /**
     * @param id
     * @return list of all users founded by "id" parameter
     */
    @GetMapping("/findAllById/{id}")
    public List<User> findAllById(@PathVariable("id") int id) {
        List<User> resultList = new LinkedList<>();
        User noUser = new User("No user founded", "", "", "", 0, 0);
        for (User elem : userList) {
            if (elem.getId() == id) {
                resultList.add(elem);
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(noUser);
        }
        return resultList;
    }
}
