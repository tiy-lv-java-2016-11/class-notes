package com.theironyard.repositories;

import com.theironyard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeff on 12/29/16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByName(String name);
}
