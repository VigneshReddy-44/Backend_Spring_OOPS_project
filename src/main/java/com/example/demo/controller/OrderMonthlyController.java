package com.example.demo.controller;

import com.example.demo.dto.LastMonthOrdersRequest;
import com.example.demo.model.Orders;
import com.example.demo.model.customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderMonthlyController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/MonthlyOrder")
    public List<Orders> monthlyOrders(@RequestBody LastMonthOrdersRequest request){
        customer c=customerRepository.findById(request.getCustomerId()).get();
        int month= LocalDate.now().getMonthValue();
        List<Orders> ordersList=new ArrayList<>();
        for(int i=c.getOrders_list().size()-1;i>=0;i--){
            if(c.getOrders_list().get(i).getMonth()<=month-2){
                break;
            }
            ordersList.add(c.getOrders_list().get(i));
        }
        return ordersList;
    }

}
