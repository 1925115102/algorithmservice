package edu.iu.c322.project.algorithmservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<MyCourse> courselist;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Request> shoppingCart;
    String request;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MyCourse> getCourselist() {
        return courselist;
    }

    public void setCourselist(List<MyCourse> courselist) {
        this.courselist = courselist;
    }

    public List<Request> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Request> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
