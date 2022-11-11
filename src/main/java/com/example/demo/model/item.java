package com.example.demo.model;

import java.util.UUID;

public class item {
    private UUID id;
    private String name;
    private String category;

    private double price;
    private int stock;

    public item(String name, String category, int stock,double price) {
        this.id=UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price=price;
    }

    public void checked_out(){
        stock--;
    }

    public UUID getId() {
        return id;
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
}

