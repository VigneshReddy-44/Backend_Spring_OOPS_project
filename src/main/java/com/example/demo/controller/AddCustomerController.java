package com.example.demo.controller;

import com.example.demo.dto.customerAddRequest;
import com.example.demo.model.customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddCustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PutMapping("/addCustomer")
    public customer addToCustomerDB(@RequestBody customerAddRequest request) {

        customer temp = new customer();
        int count = 0;
        String var = request.getMobileNumber();
        if(request.getMobileNumber().length()!=10){
            System.out.println("Invalid phone number");
            temp.setMobileNumber(null);
        }else{
            temp.setMobileNumber(request.getMobileNumber());
        }




        //temp.setId(request.getCustomerId());
        temp.setName(request.getName());
        temp.setWallet(2000);
        temp.setPassword(request.getPassword());

        List<customer> customerList=customerRepository.findAll();
        for(int i=0;i<customerList.size();i++){
            if(request.getEmail() .equals( customerList.get(i).getEmail())){
                System.out.println("Username already exists");
                return null;
            }

        }
        temp.setEmail(request.getEmail());
        return customerRepository.save(temp);

    }
}
