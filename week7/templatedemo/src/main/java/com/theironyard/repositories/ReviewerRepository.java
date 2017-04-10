package com.theironyard.repositories;

import com.theironyard.entities.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeff on 1/11/17.
 */
public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {
}
