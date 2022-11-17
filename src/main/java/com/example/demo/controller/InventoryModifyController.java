package com.example.demo.controller;

import com.example.demo.dto.InventoryModifyRequest;
import com.example.demo.model.item;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryModifyController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @PutMapping("/AddItemToInventory")
    item addToInventory(@RequestBody InventoryModifyRequest request){
        item temp=new item();
        temp.setId(request.getI1().getId());
        temp.setName(request.getI1().getName());
        temp.setCategory(request.getI1().getCategory());
        temp.setPrice(request.getI1().getPrice());
        temp.setStock(request.getI1().getStock());
        return inventoryRepository.save(temp);
    }
    @GetMapping("/Inventory")
    public List<item> findAllInInventory(){
        return inventoryRepository.findAll();
    }
}
