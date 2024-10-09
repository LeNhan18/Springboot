package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "resID")
    private Restaurant restaurant;

    @Column(name = "createdate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "foodID")
    private Food food;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> listOrderDetails;

    public Set<OrderDetail> getListOrderDetails() {
        return listOrderDetails;
    }

    public void setListOrderDetails(Set<OrderDetail> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
