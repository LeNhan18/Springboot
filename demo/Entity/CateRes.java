package com.example.demo.Entity;

import com.example.demo.Entity.KEY.IDcateres;
import jakarta.persistence.*;

@Entity
@Table(name = "cate_res")
public class CateRes {
    @EmbeddedId
    private IDcateres iDcateres;

    @ManyToOne
    @JoinColumn(name = "cateID",insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "resID",insertable = false, updatable = false)
    private Restaurant restaurant;

    public IDcateres getiDcateres() {
        return iDcateres;
    }

    public void setiDcateres(IDcateres iDcateres) {
        this.iDcateres = iDcateres;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
