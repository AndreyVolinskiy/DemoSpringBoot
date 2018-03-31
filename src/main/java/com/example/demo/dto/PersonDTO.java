package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
@Getter
@Setter
public class PersonDTO {
    private Long id;
    private String name;
    private String organization;
    private String email;
}
