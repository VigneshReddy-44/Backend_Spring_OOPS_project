package com.example.demo.controller;

import com.example.demo.dto.removeCustomerRequest;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class removeCustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @DeleteMapping("/deleteCustomer")
    void deleteCustomer(@RequestBody removeCustomerRequest request){
        customerRepository.deleteById(request.getId());
    }

}
