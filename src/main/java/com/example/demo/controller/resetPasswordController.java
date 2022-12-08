package com.example.demo.controller;

import com.example.demo.dto.resetPasswordRequest;
import com.example.demo.model.customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class resetPasswordController {
    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping("/ResetPassword")
    customer resetPassword(@RequestBody resetPasswordRequest request){
        for(int i=0;i<customerRepository.findAll().size();i++){
            if(customerRepository.findAll().get(i).getEmail().equals(request.getUserName()) && customerRepository.findAll().get(i).getPassword().equals(request.getOldPassword())){
                customerRepository.findAll().get(i).setPassword(request.getNewPassword());
                return customerRepository.findAll().get(i);
            }
        }
        return null;
    }
}
