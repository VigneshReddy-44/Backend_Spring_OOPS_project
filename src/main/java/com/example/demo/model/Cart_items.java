package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Cart_items")
public class Cart_items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cart_items_id;

    @ManyToOne(cascade = CascadeType.ALL)
    private item ordered_item;

    @Column(name = "Quantity")
    private int quantity;
    public Cart_items(){

    }

    public Cart_items(item ordered_item, int quantity) {
        this.ordered_item = ordered_item;
        this.quantity = quantity;
    }

    public item getOrdered_item() {
        return ordered_item;
    }

    public void setOrdered_item(item ordered_item) {
        this.ordered_item = ordered_item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
