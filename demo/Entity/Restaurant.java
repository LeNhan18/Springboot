package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "descs")
    private String descs;

    @Column(name = "image")
    private String image;

    @Column(name = "isfreeship")
    private boolean isFreeShip;

    @Column(name = "address")
    private String address;

    @Column(name = "opendate")
    private Date openDate;

    @Column(name = "subtitle")
    private String subTitle;


    @OneToMany(mappedBy = "restaurant")
    private Set<Ratingres> listRatingres;

    @OneToMany(mappedBy = "restaurant")
    private Set<CateRes> listCateRes;

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> listPromo;

    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> listOrders;

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

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Set<Ratingres> getListRatingres() {
        return listRatingres;
    }

    public void setListRatingres(Set<Ratingres> listRatingres) {
        this.listRatingres = listRatingres;
    }

    public Set<CateRes> getListCateRes() {
        return listCateRes;
    }

    public void setListCateRes(Set<CateRes> listCateRes) {
        this.listCateRes = listCateRes;
    }

    public Set<Promo> getListPromo() {
        return listPromo;
    }

    public void setListPromo(Set<Promo> listPromo) {
        this.listPromo = listPromo;
    }

    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }
}
