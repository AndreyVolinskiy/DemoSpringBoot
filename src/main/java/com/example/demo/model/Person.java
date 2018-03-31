package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "organization_id")
    private Long organizationId;
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
