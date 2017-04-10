package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by jeff on 1/11/17.
 */
@Entity
@Table(name = "reviewers")
public class Reviewer {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String organization;

    @Column(nullable = false)
    private String selfie;

    @Column(nullable = false)
    private String review;

    public Reviewer(String name, String position, String organization, String selfie, String review) {
        this.name = name;
        this.position = position;
        this.organization = organization;
        this.selfie = selfie;
        this.review = review;
    }

    public Reviewer() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSelfie() {
        return selfie;
    }

    public void setSelfie(String selfie) {
        this.selfie = selfie;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
