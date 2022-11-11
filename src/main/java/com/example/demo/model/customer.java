package com.example.demo.model;



import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.ArrayList;
@EntityScan
public class customer extends User {

    protected double wallet;
    protected ArrayList<Orders> cart_items;
    protected ArrayList<Orders> orders_list;

    public customer(String name, int mobileNumber, String email, String password) {
        super(name, mobileNumber, email, password,"Customer");
        this.cart_items = new ArrayList<>();
        this.orders_list=new ArrayList<>();
    }


    public ArrayList<Orders> getCart_items() {
        return cart_items;
    }

    public int cartSize() {
        return cart_items.size();
    }
    public double cartEstimate(){
        double est=0.0d;
        for(int i=0;i<cart_items.size();i++){
            est=est+cart_items.get(i).getQuantity()*cart_items.get(i).getOrdered_item().getPrice();
        }
        return est;
    }
    public void checkOut() {
        System.out.println(cartEstimate());
        for(int i=0;i<getCart_items().size();i++){
            orders_list.add(getCart_items().get(i));

        }
        cart_items=new ArrayList<>();
        return;
    }
    public void printOrderList(){
        LocalDate current_date=LocalDate.now();
        for(int i=orders_list.size()-1;i>=0;i--){

        }

    }

    @Override
    public void removeUser() {
        Admin.getCustomer_list().remove(this);
    }

    public double getWallet() {
        return wallet;
    }

    public ArrayList<Orders> getOrders_list() {
        return orders_list;
    }
}



