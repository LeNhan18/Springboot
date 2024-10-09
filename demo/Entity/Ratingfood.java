package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ratingfood")
public class Ratingfood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "foodID")
    private Food food;

    @Column(name = "content")
    private String content;

    @Column(name = "ratepoint")
    private int ratePoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
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
