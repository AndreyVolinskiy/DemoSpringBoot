package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

import java.util.List;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
public interface UserService {

    UserDTO create(String name, String login, String password, String email, int age, long orgId);

    List<UserDTO> findByEmail(String email);

    List<UserDTO> findAllByName(String name);

    List<UserDTO> findAllByLogin(String login);

    List<UserDTO> findUserInAgeBetween(int from, int to);

    UserDTO save(User user);

    UserDTO findOne(Long id);

    List<UserDTO> findAll(int limit, int offset);

    void delete(Long id);
}
