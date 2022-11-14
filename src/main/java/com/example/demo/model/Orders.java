package com.example.demo.model;


import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orders_id;
    @ManyToOne(cascade = CascadeType.ALL)
    private item ordered_item;
    @Column(name = "Quantity")
    private int quantity;


    @Column(name = "Day")
    private int date;
    @Column(name = "Month")
    private int month;
    @Column(name = "Year")
    private int year;
    public Orders(){

    }
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

