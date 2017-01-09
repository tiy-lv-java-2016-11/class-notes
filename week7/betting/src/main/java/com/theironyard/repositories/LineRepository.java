package com.theironyard.repositories;

import com.theironyard.entities.Line;
import com.theironyard.entities.SportsBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jeff on 1/9/17.
 */
public interface LineRepository extends JpaRepository<Line, Integer> {
    List<Line> findAllBySportsBook(SportsBook sportsBook);
}
