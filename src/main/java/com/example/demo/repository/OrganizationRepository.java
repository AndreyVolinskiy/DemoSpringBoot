package com.example.demo.repository;

import com.example.demo.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrey Volinskiy on 28.03.2018.
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
