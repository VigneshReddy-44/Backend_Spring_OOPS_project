package com.example.demo.controller;


import com.example.demo.dto.OrderRequest;
import com.example.demo.model.customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @PostMapping("/placeOrder")
    public customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getC1());


    }
    @GetMapping("/findAllOrders")
    public List<customer> findAllOrders(){
        return customerRepository.findAll();
    }

}
