package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Andrey Volinskiy on 21.03.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;
    @Column(name = "add_date")
    private String date;
    @Column(name = "organization_id")
    private Long organizationId;

    // TODO: 28.03.2018 create user dto (- password - orgId + String OrgName)
    // TODO: 28.03.2018 correct user service limit offset
    // TODO: 28.03.2018 the same to event model (service) limit offset

    public User(String name, String login, String password, String email, int age, Long organizationId) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.organizationId = organizationId;
    }
}
