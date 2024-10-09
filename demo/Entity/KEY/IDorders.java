package com.example.demo.Entity.KEY;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class IDorders implements Serializable {
    @Column(name="orderID")
    private int orderID;
    @Column(name = "foodID")
    private int foodID;
    public IDorders() {}
    public IDorders(int orderID, int foodID) {
        this.orderID = orderID;
        this.foodID = foodID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
