package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ratingres")
public class Ratingres {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "resID")
    private Restaurant restaurant;

    @Column(name = "content")
    private String content;

    @Column(name = "ratepoint")
    private int ratePoint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(int ratePoint) {
        this.ratePoint = ratePoint;
    }
}


