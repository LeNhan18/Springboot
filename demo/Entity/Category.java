package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "namecate")
    private String nameCate;

    @Column(name = "createdate")
    private Date createDate;

     @OneToMany(mappedBy = "category")
     private Set<Food> foodList;

     @OneToMany(mappedBy = "category")
     private Set<CateRes> listCateRes;

    public Set<CateRes> getListCateRes() {
        return listCateRes;
    }

    public void setListCateRes(Set<CateRes> listCateRes) {
        this.listCateRes = listCateRes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(Set<Food> foodList) {
        this.foodList = foodList;
    }
}
