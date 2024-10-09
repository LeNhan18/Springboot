package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "timeShip")
    private String timeShip;

    @Column(name = "price")
    private double price;
    @Column(name ="isfreeship")
    private boolean isfreeship;
    @ManyToOne
    @JoinColumn(name = "cateID")
    private Category category;

    @OneToMany(mappedBy = "food")
    private Set<Ratingfood> listRatingfood;

    @OneToMany(mappedBy = "food")
    private Set<Orders> listOrders;

    @OneToMany(mappedBy = "food")
    private Set<OrderDetail> listOrderDetail ;


    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    public Set<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(Set<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    public Set<Ratingfood> getListRatingfood() {
        return listRatingfood;
    }

    public void setListRatingfood(Set<Ratingfood> listRatingfood) {
        this.listRatingfood = listRatingfood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isfreeship() {
        return isfreeship;
    }
    public void setfreeship(boolean isfreeship) {
        this.isfreeship = isfreeship;
    }
}
