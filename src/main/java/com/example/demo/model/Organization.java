package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
}
