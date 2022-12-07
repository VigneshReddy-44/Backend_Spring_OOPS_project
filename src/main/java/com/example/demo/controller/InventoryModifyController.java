package com.example.demo.controller;

import com.example.demo.dto.InventoryModifyRequest;
import com.example.demo.dto.inventoryRemoveRequest;
import com.example.demo.model.item;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryModifyController {
    private CustomerRepository customerRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/AddItemToInventory")
    item addToInventory(@RequestBody InventoryModifyRequest request){
        for(int j=0;j<inventoryRepository.findAll().size();j++){
            if(request.getName().equalsIgnoreCase(inventoryRepository.findAll().get(j).getName())){
                inventoryRepository.findAll().get(j).setStock(request.getStock());
                return inventoryRepository.save(inventoryRepository.findAll().get(j));
            }
        }

        item i;
        i=new item(request.getName(), request.getCategory(), request.getStock(), request.getPrice(), request.getImageUrl());
        return inventoryRepository.save(i);
    }
    @GetMapping("/Inventory")
    public List<item> findAllInInventory(){
        return inventoryRepository.findAll();
    }
    @GetMapping("/Inventory/fruits")
    public List<item> findFruits(){
        List<item> res=new ArrayList<>();
        for(int i=0;i<inventoryRepository.findAll().size();i++){
            item temp=inventoryRepository.findAll().get(i);
            if(temp.getCategory().equals("fruit") || temp.getCategory().equals("Fruit") ||temp.getCategory().equals("fruits") || temp.getCategory().equals("Fruits")){
                res.add(temp);
            }
        }
        return res;
    }

    @GetMapping("/Inventory/vegetables")
    public List<item> findVegetables(){
        List<item> res=new ArrayList<>();
        for(int i=0;i<inventoryRepository.findAll().size();i++){
            item temp=inventoryRepository.findAll().get(i);
            if(temp.getCategory().equals("vegetable") || temp.getCategory().equals("Vegetable") ||temp.getCategory().equals("vegetables") || temp.getCategory().equals("Vegetables")){
                res.add(temp);
            }
        }
        return res;
    }
    @GetMapping("/Inventory/beverages")
    public List<item> findBeverages(){
        List<item> res=new ArrayList<>();
        for(int i=0;i<inventoryRepository.findAll().size();i++){
            item temp=inventoryRepository.findAll().get(i);
            if(temp.getCategory().equals("beverages") || temp.getCategory().equals("Beverages") ||temp.getCategory().equals("Beverage") || temp.getCategory().equals("beverage")){
                res.add(temp);
            }
        }
        return res;
    }
    @GetMapping("/Inventory/others")
    public List<item> findOthers(){
        List<item> res=new ArrayList<>();
        for(int i=0;i<inventoryRepository.findAll().size();i++){
            item temp=inventoryRepository.findAll().get(i);
            if(temp.getCategory().equals("others")){
                res.add(temp);
            }
        }
        return res;
    }
    @PostMapping("/DeleteItemFromInventory")
    public void deleteItem(@RequestBody inventoryRemoveRequest request){
        item temp=inventoryRepository.findById(request.getItem_id()).get();
        int initialStock= temp.getStock();
        int finalStock;
        finalStock=initialStock- request.getQuantity();
        if(finalStock<0){finalStock=0;}
        temp.setStock(finalStock);
        inventoryRepository.save(temp);
//        if(finalStock==0){
//            List<customer> customerList=customerRepository.findAll();
//            for(int k=0;k<customerList.size();k++){
//                List<Cart_items> custiCart=customerList.get(k).getCart_items();
//                for(int l=0;l<custiCart.size();l++){
//                    if(custiCart.get(l).getOrdered_item().getId()==request.getItem_id()){
//                        custiCart.remove(l);
//                    }
//                }
//            }
//            inventoryRepository.deleteById(request.getItem_id());
//
//        }else{
//            inventoryRepository.save(temp);
//        }

    }
}
