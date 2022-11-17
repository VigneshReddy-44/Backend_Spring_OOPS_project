package com.example.demo.controller;

import com.example.demo.dto.cartItemAddRequest;
import com.example.demo.model.Cart_items;
import com.example.demo.model.customer;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartItemController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @PutMapping("/addToCart")
    public customer addToCart(@RequestBody  cartItemAddRequest request){
        int item_id=request.getItem_id();
        int customer_id=request.getCustomerId();
        customer c1=customerRepository.findById(customer_id).get();
        List<Cart_items> cartItemsList=c1.getCart_items();
        for(int i=0;i<cartItemsList.size();i++){
            int id_in_cart=cartItemsList.get(i).getOrdered_item().getId();
            if(id_in_cart==item_id){
                cartItemsList.get(i).setQuantity(cartItemsList.get(i).getQuantity()+1);
                return customerRepository.save(c1);
            }
        }
        c1.getCart_items().add(new Cart_items(inventoryRepository.findById(item_id).get(),1));
        return customerRepository.save(c1);

    }
//    @DeleteMapping("/removeItemFromCart")
//    public customer removeItemFromCart(@RequestBody )

}
