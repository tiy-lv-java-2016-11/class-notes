package com.theironyard.repositories;

import com.theironyard.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jeff on 12/29/16.
 */
public interface EventRepository extends JpaRepository<Event, Integer>{
    List<Event> findAllByOrderByDateTimeDesc();
//    Event findFirst();
}