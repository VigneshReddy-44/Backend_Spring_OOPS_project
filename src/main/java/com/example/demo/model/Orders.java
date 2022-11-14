package com.example.demo.model;


import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order_id")
    private int id;
    @ManyToOne
    private item ordered_item;
    @Column(name = "Quantity")
    private int quantity;


    @Column(name = "Day")
    private int date;
    @Column(name = "Month")
    private int month;
    @Column(name = "Year")
    private int year;

    public Orders(item ordered_item, int quantity, LocalDate date) {
        this.ordered_item = ordered_item;
        this.quantity = quantity;
        this.date = date.getDayOfMonth();
        this.month=date.getMonthValue();
        this.year=date.getYear();

    }

    public item getOrdered_item() {
        return ordered_item;
    }

    public int getQuantity() {
        return quantity;
    }


}

