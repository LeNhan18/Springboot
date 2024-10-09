package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "createdate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "roleID")
    private Roles role;

    @OneToMany(mappedBy = "users")
    private Set<Ratingfood> listRatingfood;

    @OneToMany(mappedBy = "user")
    private Set<Ratingres> listRatingres;

    @OneToMany(mappedBy = "user")
    private Set<Orders> listOrders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Set<Ratingfood> getListRatingfood() {
        return listRatingfood;
    }

    public void setListRatingfood(Set<Ratingfood> listRatingfood) {
        this.listRatingfood = listRatingfood;
    }

    public Set<Ratingres> getListRatingres() {
        return listRatingres;
    }

    public void setListRatingres(Set<Ratingres> listRatingres) {
        this.listRatingres = listRatingres;
    }

    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }
}
