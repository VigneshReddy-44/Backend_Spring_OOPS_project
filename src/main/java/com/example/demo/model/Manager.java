package com.example.demo.model;


import java.util.List;

public class Manager extends User{
    static List<item> item_list;
    public Manager(String name, int mobileNumber, String email, String password) {
        super(name, mobileNumber, email, password,"Manager");
    }

    public List<item> getItem_list() {
        return item_list;

    }
    public void addItem(item c){
        int i;
        for(i=0;i< item_list.size();i++){
            if(c.getCategory()==item_list.get(i).getCategory()){
                item_list.get(i).setStock(item_list.get(i).getStock()+1);
                break;
            }
        }
        if(i== item_list.size()){
            item_list.add(c);
        }
    }
    public void removeItem(item c){
        int i;
        for(i=0;i< item_list.size();i++){
            if(c.getCategory()==item_list.get(i).getCategory()){
                item_list.get(i).setStock(item_list.get(i).getStock()-1);
                break;
            }
        }
        if(i== item_list.size()){
            item_list.remove(c);
        }
    }
}

