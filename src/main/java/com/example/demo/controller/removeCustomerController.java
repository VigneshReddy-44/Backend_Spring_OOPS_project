package com.example.demo.controller;

import com.example.demo.dto.removeCustomerRequest;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class removeCustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @PutMapping("/deleteCustomer")
    void deleteCustomer(@RequestBody removeCustomerRequest request){
        System.out.println("deleted");
        customerRepository.deleteById(request.getId());
    }

}
