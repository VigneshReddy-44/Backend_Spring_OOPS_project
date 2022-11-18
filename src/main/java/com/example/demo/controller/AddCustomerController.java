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
        int var = request.getMobileNumber();
        while (var != 0) {
            var /= 10;
            ++count;
        }
        if(count == 10){
            temp.setMobileNumber(request.getMobileNumber());
        }
        else{
            System.out.println("Invalid phone number");
        }


        //mmtemp.setId(request.getCustomerId());
        temp.setName(request.getName());
        temp.setWallet(2000);
        temp.setPassword(request.getPassword());

        List<customer> customerList=customerRepository.findAll();
        for(int i=0;i<customerList.size();i++){
            if(request.getEmail() == customerList.get(i).getEmail()){
                System.out.println("Username already exists");
            }
            else{
                temp.setEmail(request.getEmail());
            }
        }
        return customerRepository.save(temp);

    }
}
