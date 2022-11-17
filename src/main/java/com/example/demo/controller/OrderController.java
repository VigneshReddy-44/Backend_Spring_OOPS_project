package com.example.demo.controller;


import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Orders;
import com.example.demo.model.customer;
import com.example.demo.model.item;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/placeOrder")
    public customer placeOrder(@RequestBody OrderRequest request){
//        return customerRepository.save(request.getC1());
        customer c1=customerRepository.findById(request.getId_customer()).get();
        item i=inventoryRepository.findById(request.getId_item()).get();
        int stock=i.getStock();
        int quantity_requested=request.getQuantity_requested();
        if(stock>=quantity_requested){
            System.out.println(c1.getWallet());
            System.out.println(quantity_requested*i.getPrice());
            if(c1.getWallet()>=(quantity_requested*i.getPrice())){
                i.setStock(stock-quantity_requested);
                c1.getOrders_list().add(new Orders(i,quantity_requested, LocalDate.now()));
                c1.setWallet(c1.getWallet()-quantity_requested*i.getPrice());
                System.out.println(c1.getOrders_list().get(0));
                return customerRepository.save(c1);

            }else{
                System.out.println("Insufficient balance");
            }
        }else{
            System.out.println("Sufficient quantity not in stock");
        }
        return null;
    }
    @GetMapping("/findAllOrders")
    public List<customer> findAllOrders(){
        return customerRepository.findAll();
    }

}
