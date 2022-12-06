package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
public class item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "imageUrl")
    private String imageUrl;
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public item(){

    }
    public item(String name, String category, int stock,double price,String imageUrl) {

        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price=price;
        this.imageUrl=imageUrl;
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

