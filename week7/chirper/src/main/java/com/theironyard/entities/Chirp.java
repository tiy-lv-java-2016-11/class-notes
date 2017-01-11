package com.theironyard.entities;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jeff on 1/11/17.
 */
@Entity
@Table(name = "chirps")
public class Chirp {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private User user;

    public Chirp(String message, String subject, User user) {
        this.message = message;
        this.subject = subject;
        this.user = user;
    }

    public Chirp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
