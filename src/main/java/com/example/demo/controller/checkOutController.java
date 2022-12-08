package com.example.demo.controller;

import com.example.demo.dto.checkOutRequest;
import com.example.demo.model.Cart_items;
import com.example.demo.model.Orders;
import com.example.demo.model.customer;
import com.example.demo.model.item;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class checkOutController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/checkOut")
    customer checkOut(@RequestBody checkOutRequest request){
        System.out.println("Start");
        customer c=customerRepository.findById(request.getCustomer_id()).get();
        if(c!=null){
            List<Cart_items> cartItemsList=c.getCart_items();
            for(int i=0;i<cartItemsList.size();i++){
                item temp=cartItemsList.get(i).getOrdered_item();
                item inv=inventoryRepository.findById(temp.getId()).get();
                if(cartItemsList.get(i).getQuantity()>inv.getStock()){
                    return new customer("INSUFFICIENT STOCK",null,null,null);
                }
            }
            double cartPrice=c.cartEstimate();
            double balance=c.getWallet()-cartPrice;
            if(balance<0){
                return new customer("INSUFFICIENT BALANCE",null,null,null);
            }

            c.setWallet(balance);
            List<Orders> orders=c.getOrders_list();
            for(int i=0;i<cartItemsList.size();i++){
                inventoryRepository.findById(cartItemsList.get(i).getOrdered_item().getId()).get().setStock(inventoryRepository.findById(cartItemsList.get(i).getOrdered_item().getId()).get().getStock()-cartItemsList.get(i).getQuantity());
                orders.add(new Orders(cartItemsList.get(i).getOrdered_item(),cartItemsList.get(i).getQuantity(), LocalDate.now()));
            }
            cartItemsList.clear();
            customerRepository.save(c);
            return c;
        }
        return null;

    }
}
