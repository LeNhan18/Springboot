package com.example.demo.Entity;

import com.example.demo.Entity.KEY.IDorders;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    private IDorders idorders;
    @ManyToOne
    @JoinColumn(name = "orderID",insertable = false, updatable = false)
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "foodID",insertable = false, updatable = false)
    private Food food;
    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "price")
    private double price;

    public IDorders getIdorders() {
        return idorders;
    }

    public void setIdorders(IDorders idorders) {
        this.idorders = idorders;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
