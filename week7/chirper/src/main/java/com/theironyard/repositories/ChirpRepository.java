package com.theironyard.repositories;

import com.theironyard.entities.Chirp;
import com.theironyard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jeff on 1/11/17.
 */
public interface ChirpRepository extends JpaRepository<Chirp, Integer>{
    List<Chirp> findByUser(User user);
}
