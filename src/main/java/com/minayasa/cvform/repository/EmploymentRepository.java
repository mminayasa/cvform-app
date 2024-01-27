package com.minayasa.cvform.repository;

import com.minayasa.cvform.entity.Employment;
import com.minayasa.cvform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {
    List<Employment> findByUser(User user);
}
