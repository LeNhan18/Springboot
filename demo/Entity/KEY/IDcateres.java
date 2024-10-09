package com.example.demo.Entity.KEY;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class IDcateres implements Serializable {
       @Column(name = "cateID")
        private int cateID;
       @Column(name = "resID")
       private int resID;
         public IDcateres() {


         }
         public IDcateres(int cateID, int resID) {
             this.cateID = cateID;
             this.resID = resID;
         }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }
}
