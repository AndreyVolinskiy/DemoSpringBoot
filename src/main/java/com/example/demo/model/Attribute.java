package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Andrey Volinskiy on 23.03.2018.
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private Integer level;

    public Attribute(String name, Integer level) {
        this.name = name;
        this.level = level;
    }
}
