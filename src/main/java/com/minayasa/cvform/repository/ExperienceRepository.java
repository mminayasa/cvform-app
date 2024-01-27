package com.minayasa.cvform.repository;

import com.minayasa.cvform.entity.Experience;
import com.minayasa.cvform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    @Query("SELECT e FROM Experience e WHERE e.user = ?1")
    public Experience fetchExperienceByUser(User user);
}
