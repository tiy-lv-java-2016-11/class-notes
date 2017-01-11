package com.theironyard.repositories;

import com.theironyard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeff on 1/11/17.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findFirstByUsername(String username);
}
