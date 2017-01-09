package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by jeff on 1/9/17.
 */
@Entity
public class Line {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private double line;

    @ManyToOne
    private SportsBook sportsBook;

    public Line() {
    }

    public Line(String gameName, double line, SportsBook sportsBook) {
        this.gameName = gameName;
        this.line = line;
        this.sportsBook = sportsBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getLine() {
        return line;
    }

    public void setLine(double line) {
        this.line = line;
    }

    public SportsBook getSportsBook() {
        return sportsBook;
    }

    public void setSportsBook(SportsBook sportsBook) {
        this.sportsBook = sportsBook;
    }
}
