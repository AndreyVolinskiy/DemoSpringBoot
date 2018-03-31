package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrey Volinskiy on 31.03.2018.
 */
@Getter
@Setter
public class UserDTO {
    private long id;
    private String name;
    private String login;
    private String email;
    private String orgName;
    private int age;
    private String date;
}
