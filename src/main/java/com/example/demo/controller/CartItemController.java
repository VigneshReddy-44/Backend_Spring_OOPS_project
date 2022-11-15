package com.example.demo.controller;

import com.example.demo.dto.cartItemAddRequest;
import com.example.demo.model.Cart_items;
import com.example.demo.model.customer;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CartItemController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @PutMapping("/addToCart")
    public customer placeOrder(@RequestBody  cartItemAddRequest request){
        Cart_items cItem=request.getCartItem();
        int customer_id=request.getCustomerId();
        Optional<customer> c1=customerRepository.findById(customer_id);
        customer cTemp=c1.get();
        cTemp.getCart_items().add(cItem);
        return customerRepository.save(cTemp);


    }
}
