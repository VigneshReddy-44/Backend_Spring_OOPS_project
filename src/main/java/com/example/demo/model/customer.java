package com.example.demo.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Customers")
public class customer extends User {
    @Column(name = "wallet")
    protected double wallet;
@OneToMany(targetEntity = Cart_items.class,cascade = CascadeType.ALL)
@JoinColumn(name="cp_fk_cart")
    protected List<Cart_items> cart_items;
@OneToMany(targetEntity = Orders.class,cascade = CascadeType.ALL)
@JoinColumn(name="cp_fk_order")
    protected List<Orders> orders_list;
    public customer(){

    }
    public customer(String name, int mobileNumber, String email, String password) {
        super(name, mobileNumber, email, password,"Customer");
//        this.cart_items = new List<>();
//        this.orders_list=new List<>();
    }


    public List<Cart_items> getCart_items() {
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
            Orders o=new Orders(getCart_items().get(i).getOrdered_item(),getCart_items().get(i).getQuantity(), LocalDate.now());
            orders_list.add(o);

        }
        cart_items.clear();
        return;
    }
    public void printOrderList(){
        LocalDate current_date=LocalDate.now();
        for(int i=orders_list.size()-1;i>=0;i--){

        }

    }

//    @Override
//    public void removeUser() {
//        Admin.getCustomer_list().remove(this);
//    }

    public double getWallet() {
        return wallet;
    }

    public List<Orders> getOrders_list() {
        return orders_list;
    }
}



