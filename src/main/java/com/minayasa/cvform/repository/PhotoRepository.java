package com.minayasa.cvform.repository;

import com.minayasa.cvform.entity.PhotoProfile;
import com.minayasa.cvform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhotoRepository extends JpaRepository<PhotoProfile, Long> {

    @Query("SELECT e FROM PhotoProfile e WHERE e.user = ?1")
    public PhotoProfile fetchPhotoByUser(User user);
}
