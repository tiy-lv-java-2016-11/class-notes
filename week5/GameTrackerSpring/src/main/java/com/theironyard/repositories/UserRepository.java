package com.theironyard.repositories;

import com.theironyard.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeff on 12/28/16.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findFirstByName(String userName);
}
