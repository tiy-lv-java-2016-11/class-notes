package com.theironyard.repositories;

import com.theironyard.entities.SportsBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeff on 1/9/17.
 */
public interface SportsBookRepository extends JpaRepository<SportsBook, Integer> {
    SportsBook findFirstByToken(String token);
}
