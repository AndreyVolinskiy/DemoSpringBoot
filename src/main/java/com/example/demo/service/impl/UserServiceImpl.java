package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public UserDTO create(String name, String login, String password, String email, int age, long orgId) {
        User user = userRepository.save(new User(name, login, password, email, age, orgId));
        return mappingToUserDto(user);
    }

    @Override
    public List<UserDTO> findByEmail(String email) {
        Assert.notNull(email, "email can't be null");
        return listMappingToUserDTO(userRepository.findAllByEmailOwn(email));
    }

    @Override
    public List<UserDTO> findAllByName(String name) {
        Assert.notNull(name,"1st parameter can't be null");
        return listMappingToUserDTO(userRepository.findAllByName(name));
    }

    @Override
    public List<UserDTO> findAllByLogin(String login) {
        Assert.notNull(login,"login parameter can't be null");
        return listMappingToUserDTO(userRepository.findAllByLogin(login));
    }

    @Override
    public List<UserDTO> findUserInAgeBetween(int from, int to) {
        Assert.notNull(from,"1st parameter can't be null");
        Assert.notNull(to,"2nd parameter can't be null");
        return listMappingToUserDTO(userRepository.findUserInAgeBetween(from, to));
    }

    @Override
    public UserDTO save(User user) {
        Assert.notNull(user, "user can't be null");
        user.setDate(LocalDate.now().toString());
        return mappingToUserDto(userRepository.save(user));
    }

    @Override
    public UserDTO findOne(Long id) {
        Assert.notNull(id,"id can't be null");
        return mappingToUserDto(userRepository.findById(id).get());
    }

    @Override
    public List<UserDTO> findAll(int limit, int offset) {
        Page<User> list = userRepository.findAll(PageRequest.of(offset, limit));
        System.out.println(limit);
        System.out.println(offset);
        List<UserDTO> userDTOList = new LinkedList<>();
        list.map(s -> userDTOList.add(mappingToUserDto(s)));
        return userDTOList;
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id,"id can't be null");
        userRepository.deleteById(id);
    }

    private UserDTO mappingToUserDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLogin(user.getLogin());
        userDTO.setEmail(user.getEmail());
        userDTO.setAge(user.getAge());
        String orgName = organizationRepository.findById(user.getOrganizationId()).get().getName();
        userDTO.setOrgName(orgName);
        userDTO.setDate(user.getDate());
        return userDTO;
    }

    private List<UserDTO> listMappingToUserDTO(List<User> list) {
        List<UserDTO> resultList = new LinkedList<>();
        list.forEach(user -> resultList.add(mappingToUserDto(user)));
        return resultList;
    }
}
