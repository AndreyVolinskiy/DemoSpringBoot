package com.example.demo.repository;

import com.example.demo.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrey Volinskiy on 23.03.2018.
 */
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
