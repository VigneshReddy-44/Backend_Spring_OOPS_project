package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
public class item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Item_id")
    private int id;
    @Column(name = "Item_name")
    private String name;
    @Column(name = "Item_category")
    private String category;
    @Column(name = "Price")
    private double price;
    @Column(name = "Stock")
    private int stock;

    public item(String name, String category, int stock,double price) {

        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price=price;
    }

    public void checked_out(){
        stock--;
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
}

