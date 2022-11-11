package com.example.demo.model;

import java.util.ArrayList;

public class Admin extends Manager{
    static ArrayList<customer> customer_list;
    //    static ArrayList<item> item_list;
    public Admin(String name, int mobileNumber, String email,String password) {
        super(name, mobileNumber, email,password);
        this.type_of_user="Admin";
    }

    public static ArrayList<customer> getCustomer_list() {
        return customer_list;
    }

    public ArrayList<item> getItem_list() {
        return item_list;
    }
    public void addCustomer(customer c){
        customer_list.add(c);
    }
    public void removeCustomer(customer c){
        customer_list.remove(c);
    }

//    public void items_sold_on_day(){
//        LocalDate date=LocalDate.now();
//        for(int i=0;i<item_list.size();i++){
//            if(item_list.get(i).)
//        }
//    }






//    public void addItem(item c){
//        int i;
//        for(i=0;i< item_list.size();i++){
//            if(c.getCategory()==item_list.get(i).getCategory()){
//                item_list.get(i).setStock(item_list.get(i).getStock()+1);
//                break;
//            }
//        }
//        if(i== item_list.size()){
//            item_list.add(c);
//        }
//    }
//    public void removeItem(item c){
//        int i;
//        for(i=0;i< item_list.size();i++){
//            if(c.getCategory()==item_list.get(i).getCategory()){
//                item_list.get(i).setStock(item_list.get(i).getStock()-1);
//                break;
//            }
//        }
//        if(i== item_list.size()){
//            item_list.remove(c);
//        }
//    }

}

