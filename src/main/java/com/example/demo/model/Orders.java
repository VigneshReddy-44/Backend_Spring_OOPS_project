package com.example.demo.model;



import java.time.LocalDate;

public class Orders {
    private item ordered_item;
    private int quantity;
    private LocalDate date;

    public Orders(item ordered_item, int quantity, LocalDate date) {
        this.ordered_item = ordered_item;
        this.quantity = quantity;
        this.date = date;
    }

    public item getOrdered_item() {
        return ordered_item;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }
}

