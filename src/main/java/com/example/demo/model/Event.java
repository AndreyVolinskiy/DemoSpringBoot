package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Andrey Volinskiy on 21.03.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Event(String name) {
        this.name = name;
    }
}
