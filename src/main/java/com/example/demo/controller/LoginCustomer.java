package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.model.customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LoginCustomer {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/Login")
    public customer login(@RequestBody LoginRequest request){
        List<customer> customerList=customerRepository.findAll();
        for(int i=0;i<customerList.size();i++){
            if((customerList.get(i).getEmail().equals(request.getUsername()))){
                if(customerList.get(i).getPassword().equals( request.getPassword())){
                    System.out.println("Logged in");
                    return customerList.get(i);
                }


            }
        }
        System.out.println("Customer not found");
        return null;
    }
}
