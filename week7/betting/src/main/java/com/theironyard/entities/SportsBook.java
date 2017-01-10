package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by jeff on 1/9/17.
 */
@Entity
public class SportsBook {
    private static final int EXPIRATION_DAYS = 3;

    @Id
    @GeneratedValue
    @Min(0)
    private int id;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    @Size(min = 10, max = 100, message = "Name must be between 10 and 100")
    private String name;

    @OneToMany(mappedBy = "sportsBook")
    @JsonIgnore
    private List<Line> lines;

    @Column(nullable = true, unique = true)
    @JsonIgnore
    private String token;

    @Column(nullable = false)
    @ColumnDefault("'1970-01-01'")
    private LocalDateTime expiration;

    public SportsBook(String name, String password) {
        this.name = name;
        this.password = password;
        setTokenAndExpiration();
    }

    public SportsBook() { //JPA
        setTokenAndExpiration();
    }

    /**
     * Generates new token and sets the expiration date in the future
     */
    private void setTokenAndExpiration(){
        this.token = generateToken();
        this.expiration = LocalDateTime.now().plus(EXPIRATION_DAYS, ChronoUnit.DAYS);
    }

    public String generateToken(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public boolean isTokenValid(){
        return expiration.isAfter(LocalDateTime.now());
    }

    public String regenerate(){
        setTokenAndExpiration();
        return token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

}
