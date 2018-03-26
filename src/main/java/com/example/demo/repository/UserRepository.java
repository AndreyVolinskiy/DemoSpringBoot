package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Andrey Volinskiy on 23.03.2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);

    User findByEmail(String email);

    List<User> findAllByEmailAndAgeAndNameAndPassword(String email, int age, String name, String password);

    @Query(value = "select * from users WHERE age BETWEEN ?1 AND ?2;", nativeQuery = true)
    List<User> findUserByAgeBetween(int from, int to);

    @Query(value = "SELECT * FROM users WHERE email = :userEmail", nativeQuery = true)
    List<User> findAllByEmailOwn(@Param("userEmail") String email);
}
